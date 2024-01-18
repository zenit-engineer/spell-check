//package com.zenit.spellcheck.controller;
//
//import com.zenit.spellcheck.config.MessageProducer;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class KafkaController {
//
//
//    private final MessageProducer messageProducer;
//
//    @PostMapping("/send")
//    public String sendMessage(@RequestParam("message") String message) {
//        messageProducer.sendMessage("my-topic", message);
//        return "Message sent: " + message;
//    }
//
//}