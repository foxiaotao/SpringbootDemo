package com.simon.service.impl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.simon.service.ISendMailService;
@Service
public class SendMailSerivceImpl implements ISendMailService {

	
	@Autowired
	@Qualifier(value="myJavaMailSenderImpl")
	private JavaMailSenderImpl javaMailSenderImpl;
	
	@Value("${spring.mail.username}")
    private String mailUserName;
	
	@Override
	public void sendMail() {
//		SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(mailUserName);
//        message.setTo(mailUserName); //自己给自己发送邮件
//        message.setSubject("主题：简单邮件");
//        message.setText("测试邮件内容");
//        javaMailSenderImpl.send(message);
		
		MimeMessage message = null;
        try {
            message = javaMailSenderImpl.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "GBK");
            helper.setFrom(mailUserName);
            String[] snetTo = {"384631173@qq.com","1601507152@qq.com"};
            helper.setTo(snetTo);
            String[] cc = {"bingtao.zhai@quantgroup.cn","tao.sun@quantgroup.cn"};
            helper.setCc(cc);
            helper.setSubject("京东预警_测试群发送_小涛test");

            StringBuffer html = new StringBuffer();
            html = LoanHtmlUtil.getStlye(html);
            html = LoanHtmlUtil.getDevStart(html);
            html = LoanHtmlUtil.getTableStart(html, "审核超时订单");
            for (int i = 0; i < 10; i++) {
            	html = LoanHtmlUtil.getOneLine(html, (100+i)+"", "channelNo_"+i, (i+444)+"", 11.5f);
			}
            html = LoanHtmlUtil.getTableEnd(html);
            html = LoanHtmlUtil.getBr(html);
            html = LoanHtmlUtil.getBr(html);
            html = LoanHtmlUtil.getTableStart(html, "放款超时订单");
            for (int i = 0; i < 5; i++) {
            	html = LoanHtmlUtil.getOneLine(html, (100+i)+"", "channelNo_"+i, (i+444)+"", 21.5f);
			}
            html = LoanHtmlUtil.getTableEnd(html);
            html = LoanHtmlUtil.getDevEnd(html);
            helper.setText(html.toString(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        javaMailSenderImpl.send(message);
		
	}

}
