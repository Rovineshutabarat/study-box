package com.study.box.server.service;

import jakarta.mail.MessagingException;

public interface MailService {
    void sendMail(String to, String subject, String content) throws MessagingException;
}
