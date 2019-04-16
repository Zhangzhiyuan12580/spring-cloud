package com.spring.cloud.basic.service;

import com.spring.cloud.basic.dto.UserMsg;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @Author zzy
 * @Date 2019-04-08-20:57
 * @Description 用户信息发送kafka
 **/
@Component
@Log4j2
public class UserMsgSender {

    public static final String UPDATE = "update";
    public static final String DELETE = "delete";

    @Autowired
    private Source source;

    public void sendMsg(UserMsg userMsg) {
        log.info("发送用户信息：{}", userMsg);
        this.source.output().send(MessageBuilder.withPayload(userMsg).build());
    }
}
