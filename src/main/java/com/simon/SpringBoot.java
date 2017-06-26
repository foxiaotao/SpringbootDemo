package com.simon;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 * Created by xiaotao on 2017/5/16.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.simon","com.simon.config.mq"})
@PropertySource(value={"classpath:application.properties"})
@EnableWebMvc
@EnableScheduling
public class SpringBoot {


    public static void parseOptions(String[] args) throws ParseException {
    }

    public static void main(String[] args) {
//        parseOptions(args);
        SpringApplication.run(SpringBoot.class, args);
    }
}
