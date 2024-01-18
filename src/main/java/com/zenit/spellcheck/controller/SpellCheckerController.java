package com.zenit.spellcheck.controller;

import com.zenit.spellcheck.service.SpellCheckService;
import com.zenit.spellcheck.util.ResponseJsonBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/api/v1/spell-check")
public class SpellCheckerController {

    private final SpellCheckService spellCheckService;

    @GetMapping("/match")
    public ResponseEntity<ResponseJsonBody> spellCheck(
            @RequestHeader String key,
            @RequestHeader String ip,
            @RequestHeader String language,
            @RequestParam String word){

        ResponseJsonBody updateProjectByIdResponse = spellCheckService.spellCheck(key, ip, language, word);

        return new ResponseEntity<>(

                updateProjectByIdResponse,
                updateProjectByIdResponse.getStatus()

        );

    }

    @GetMapping("/remote-address")
    public void getRemoteAddress(HttpServletRequest httpServletRequest){

        log.info("Device that is requesting this API has IP : {}", httpServletRequest.getRemoteAddr());

    }

//    @GetMapping("/consume")
//    public String consume(){
//
//        // Send message to Kafka to notify the email microservice
//        return "Spell check completed. Email microservice notified.";
//
//    }



}

