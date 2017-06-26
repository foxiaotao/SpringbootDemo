package com.simon.service.impl;

import com.simon.service.IQueueService;
import org.springframework.stereotype.Service;

/**
 * Created by xiaotao on 2017/5/22.
 */
@Service("queueService")
public class QueueServiceImpl implements IQueueService {
    @Override
    public void handleMessage(String data) {
        System.out.println("我收到消息了==="+data);
    }
}
