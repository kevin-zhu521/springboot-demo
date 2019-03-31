package com.xiaoi.service.impl;

import com.xiaoi.SpringboottaskApplicationTests;
import com.xiaoi.contants.MailContant;
import com.xiaoi.service.SendMailService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @author kevin.zhu
 * @date 2019/3/31 11:33
 */
public class SendMailServiceImplTest extends SpringboottaskApplicationTests{
    @Autowired
    private SendMailService sendMailService;

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Test
    public void sendMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("问题总结");
        message.setText("您好，以下是对问题的总结，请知悉!");
        message.setFrom("1023846358@qq.com");
        message.setTo("kevin.zhu@xiaoi.com");

        sendMailService.sendMail(message);
    }

    @Test
    public void sendMimeMail() throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
//        mimeMessageHelper.setText(MailContant.content, true);//文件内容复杂不行
        mimeMessageHelper.setText("<b style='color:red'> 今晚开会 </b>", true);
        mimeMessageHelper.setSubject("关于复杂邮箱测试");
        mimeMessageHelper.setFrom("1023846358@qq.com");
        mimeMessageHelper.setTo("a1023846358@163.com");
        mimeMessageHelper.addAttachment("1.png",new File("C:\\Users\\User\\Desktop\\pic\\图片1.png"));

        javaMailSender.send(mimeMessage);
    }

}