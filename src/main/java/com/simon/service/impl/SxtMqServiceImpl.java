package com.simon.service.impl;

import com.simon.service.IMQService;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * Created by xiaotao on 2017/5/18.
 */
@Service("sxtMqService")
public class SxtMqServiceImpl implements IMQService{

    @Autowired
    @Qualifier(value = "sxtRabbitTemplate")
    private RabbitTemplate rabbitTemplate;

    @Autowired
    @Qualifier(value = "sxtQueue")
    Queue loanOrderQueue;

    @Override
    public void send(String message) {
        if (StringUtils.isEmpty(message)){
            return;
        }
        rabbitTemplate.convertAndSend(loanOrderQueue.getName(),message);
    }

    @Override
    public void send(Long loanId, Long loanProgress, Long termNo) {

    }
}
