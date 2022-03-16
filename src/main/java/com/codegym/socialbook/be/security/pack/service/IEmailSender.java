package com.codegym.socialbook.be.security.pack.service;

public interface IEmailSender {
    void send (String to, String body, String topic);
}
