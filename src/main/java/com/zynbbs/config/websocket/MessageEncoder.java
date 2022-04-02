package com.zynbbs.config.websocket;

import com.alibaba.fastjson.JSON;
import com.zynbbs.util.Message;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoder implements Encoder.Text<Message> {
    @Override
    public String encode(Message o) {
        return JSON.toJSONString(o);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
