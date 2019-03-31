package com.xiaoi.service;

import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;
import java.util.PrimitiveIterator;

/**
 * @author kevin.zhu
 * @date 2019/3/31 11:27
 */
public interface SendMailService {

    public void sendMail(SimpleMailMessage message);

    public void sendMimeMail(MimeMessage message);

}
