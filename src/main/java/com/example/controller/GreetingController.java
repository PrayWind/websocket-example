package com.example.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 例子     本例参考链接：https://www.jianshu.com/p/60799f1356c5
 * @author: whf
 * @date: 2020-7-31 11:13:02
 */
@Controller
public class GreetingController {
    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping("/helloSocket")
    public String index() {
        System.out.println("helloSocket方法进入...");
        return "index";
    }

//    // 法一：
//    @MessageMapping("/change-notice")
//    public void greeting(String value) {
//        // 这行代码也可以用@SendTo注解代替
//        this.simpMessagingTemplate.convertAndSend("/topic/notice", value);
//    }

    // 法二：（推荐）
    @MessageMapping("/change-notice")
    @SendTo("/topic/notice")
    public String greeting(String value) {
        return value;
    }
}
