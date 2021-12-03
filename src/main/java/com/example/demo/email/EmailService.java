package com.example.demo.email;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender{

    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    private final JavaMailSender mailSender;

    @Override
    // This message should be async so that it won't block the client
    @Async
    public void send(String to, String email) {
        try {
            // Create a mime message with the JavaMailSender
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            // Create a helper for the message
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            // Set the text, the receiver, subject and the sender
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Confirm your email");
            helper.setFrom("vandijckarno@hotmail.com");
            // Send the email
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            // We don't want to send the error to the user, that's why we log it
            LOGGER.error("Failed to send email", e);
            throw new IllegalStateException("Failed to send email");
        }
    }
}
