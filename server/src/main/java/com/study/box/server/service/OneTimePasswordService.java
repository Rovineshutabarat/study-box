package com.study.box.server.service;

import com.study.box.server.models.entity.OneTimePassword;
import com.study.box.server.models.payload.request.EmailRequest;
import com.study.box.server.models.payload.request.OneTimePasswordRequest;
import jakarta.mail.MessagingException;

public interface OneTimePasswordService {
    OneTimePassword generateOneTimePassword(String email);

    OneTimePassword findByCode(String code);

    Void sendOneTimePassword(EmailRequest emailRequest) throws MessagingException;

    OneTimePassword verifyOneTimePassword(OneTimePasswordRequest oneTimePasswordRequest);

    String loadOneTimePasswordTemplate(String code);
}
