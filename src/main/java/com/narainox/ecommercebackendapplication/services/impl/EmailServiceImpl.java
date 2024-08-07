package com.narainox.ecommercebackendapplication.services.impl;

import com.narainox.ecommercebackendapplication.services.EmailService;
import com.narainox.ecommercebackendapplication.utils.Email;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;
    @Override
    public String sendEmail(Email email) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("Ayush Shrivastava<"+sender+">");
            mailMessage.setTo(email.getRecipient());
            mailMessage.setSubject(email.getSubject());
            mailMessage.setText(email.getMessage());

            javaMailSender.send(mailMessage);
            return "Email sent successfully!";
        } catch (Exception e) {
            return "Email sending error!";
        }
    }

    @Override
    public String sendEmailWithAttachment(Email email) throws MessagingException {
        try {
            // Create mime message
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom("Ayush Shrivastava<" + sender + ">");
            mimeMessageHelper.setTo(email.getRecipient());
            mimeMessageHelper.setSubject(email.getSubject());
            mimeMessageHelper.setText(email.getMessage());

            // adding the attachment
            mimeMessageHelper.addAttachment(email.getAttachment().getOriginalFilename(),
                    email.getAttachment());

            // send the mail
            javaMailSender.send(mimeMessage);
            return "Mail sent successfully!";
        }
        catch (Exception e)
        {
            return "Email sending error!";
        }
    }
}
