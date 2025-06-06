package com.study.box.server.service.implementations;

import com.study.box.server.configurations.AuthConfiguration;
import com.study.box.server.models.entity.OneTimePassword;
import com.study.box.server.models.entity.User;
import com.study.box.server.models.exception.AuthException;
import com.study.box.server.models.payload.request.EmailRequest;
import com.study.box.server.models.payload.request.OneTimePasswordRequest;
import com.study.box.server.repositories.OneTimePasswordRepository;
import com.study.box.server.repositories.UserRepository;
import com.study.box.server.service.MailService;
import com.study.box.server.service.OneTimePasswordService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.security.SecureRandom;
import java.util.Date;

@Service
@AllArgsConstructor
public class OneTimePasswordServiceImpl implements OneTimePasswordService {
    private final OneTimePasswordRepository oneTimePasswordRepository;
    private final UserRepository userRepository;
    private final MailService mailService;
    private final AuthConfiguration authConfiguration;
    private final SpringTemplateEngine templateEngine;

    @Override
    public OneTimePassword generateOneTimePassword(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new AuthException("User was not found.")
        );

        // Invalidate previous otp
        oneTimePasswordRepository.findByUser(user).ifPresent(otp -> {
            otp.setAvailable(false);
            oneTimePasswordRepository.save(otp);
        });

        if (user.getIsVerified() == true) {
            throw new AuthException("User is already verified.");
        }

        SecureRandom secureRandom = new SecureRandom();
        String code = String.format("%06d", secureRandom.nextInt(1_000_000));

        return oneTimePasswordRepository.save(OneTimePassword.builder()
                .code(code)
                .isAvailable(true)
                .user(user)
                .expiredAt(new Date(System.currentTimeMillis() + (authConfiguration.getOtpExpiration() * 5))) // 5 Minutes
                .build());
    }

    @Override
    public OneTimePassword findByCode(String code) {
        return oneTimePasswordRepository.findByCode(code).orElseThrow(
                () -> new AuthException("One time password was not found.")
        );
    }

    @Override
    public Void sendOneTimePassword(EmailRequest emailRequest) throws MessagingException {
        OneTimePassword oneTimePassword = generateOneTimePassword(emailRequest.getEmail());
        mailService.sendMail(emailRequest.getEmail(), "Verify Your Identity", loadOneTimePasswordTemplate(oneTimePassword.getCode()));
        return null;
    }

    @Override
    public OneTimePassword verifyOneTimePassword(OneTimePasswordRequest oneTimePasswordRequest) {
        OneTimePassword oneTimePassword = findByCode(oneTimePasswordRequest.getCode());
        if (!oneTimePassword.isAvailable()) {
            throw new AuthException("One time password is invalid.");
        }
        if (oneTimePassword.getExpiredAt().before(new Date())) {
            throw new AuthException("One time password has expired.");
        }
        User user = oneTimePassword.getUser();
        user.setIsVerified(true);
        userRepository.save(user);

        oneTimePassword.setAvailable(false);
        oneTimePasswordRepository.save(oneTimePassword);

        return oneTimePassword;
    }

    @Override
    public String loadOneTimePasswordTemplate(String code) {
        Context context = new Context();
        context.setVariable("otp_code", code);

        return templateEngine.process("otp_template.html", context);
    }
}
