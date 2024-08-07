package com.narainox.ecommercebackendapplication.controllers;

import com.narainox.ecommercebackendapplication.services.EmailService;

import com.narainox.ecommercebackendapplication.utils.Email;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationController {
    @Autowired
    private EmailService emailService;
    @PostMapping("/sendMail")
    public String sendMail(@RequestBody Email email) {
        return emailService.sendEmail(email);
    }

    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(@ModelAttribute Email email) throws MessagingException {
        return emailService.sendEmailWithAttachment(email);
    }
}
