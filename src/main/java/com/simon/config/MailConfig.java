package com.simon.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * Created by xiaotao on 2017/5/16.
 */
@Configuration
public class MailConfig {
    @Value("${spring.mail.host}")
    private String mailHost;
    @Value("${spring.mail.username}")
    private String mailUserName;
    @Value("${spring.mail.password}")
    private String password;
    @Value("${spring.mail.properties.mail.smtp.auth}")
    private String smtpAuth;
    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private Boolean starttlsEnable;
    @Value("${spring.mail.properties.mail.smtp.starttls.required}")
    private Boolean required;

    /**
     * mail的获取连接的工厂
     * @return CachingConnectionFactory
     */
    @Bean(name="myJavaMailSenderImpl")
    public JavaMailSenderImpl javaMailSenderImpl(){
    	JavaMailSenderImpl javaMail = new JavaMailSenderImpl();
    	javaMail.setHost(mailHost);
    	javaMail.setUsername(mailUserName);
    	javaMail.setPassword(password);
    	Properties pp = new Properties();
    	pp.setProperty("mail.smtp.auth", smtpAuth);
    	javaMail.setJavaMailProperties(pp); 
        return javaMail;
    }

}
