package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @description: 全局配置信息     本例参考链接：https://www.jianshu.com/p/60799f1356c5
 * @author: whf
 * @date: 2020-7-31 11:13:09
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 服务器配置
        // 添加一个 /socket 连接点，接收客户端的连接
        registry.addEndpoint("/socket").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 客户端配置
        // 客户端给服务端发消息的地址前缀
        registry.setApplicationDestinationPrefixes("/app");
        // 客户端接收服务端的地址前缀
        registry.enableSimpleBroker("/topic");
    }
}
