package com.narainox.ecommercebackendapplication.services;

import com.narainox.ecommercebackendapplication.utils.Email;
import jakarta.mail.MessagingException;

public interface EmailService {
    String sendEmail(Email email);
    String sendEmailWithAttachment(Email email) throws MessagingException;
}
