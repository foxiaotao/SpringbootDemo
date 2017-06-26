package com.simon.Util;

import com.simon.service.IMQService;

/**
 * Created by xiaotao on 2017/5/18.
 */

public class MqUtil {

    public static void sendMessage(String message){
        IMQService sxtMqService = ApplicationContextHolder.getBean("sxtMqService");
        sxtMqService.send(message);
    }
}
