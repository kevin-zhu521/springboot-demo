package com.xiaoi.service.impl;

import com.xiaoi.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import sun.util.resources.cldr.ga.CurrencyNames_ga;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author kevin.zhu
 * @date 2019/3/31 11:28
 */
@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Override
    public void sendMail(SimpleMailMessage message) {
        javaMailSender.send(message);
    }

    @Override
    public void sendMimeMail(MimeMessage message) {
        javaMailSender.send(message);
    }
}
