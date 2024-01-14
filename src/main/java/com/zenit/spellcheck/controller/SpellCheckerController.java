package com.zenit.spellcheck.controller;


import com.zenit.spellcheck.service.SpellCheckService;
import com.zenit.spellcheck.util.ResponseJsonBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "api/v1/spell-check")
public class SpellCheckerController {

    private final SpellCheckService spellCheckService;


    @GetMapping("/match")
    public ResponseEntity<ResponseJsonBody> spellCheck(@RequestParam String word){

        ResponseJsonBody updateProjectByIdResponse = spellCheckService.spellCheck(word);

        return new ResponseEntity<>(

                updateProjectByIdResponse,
                updateProjectByIdResponse.getStatus()

        );

    }

    @GetMapping("/remote-address")
    public void getRemoteAddress(HttpServletRequest httpServletRequest){

        log.info("Device that is requesting this API has IP : {}", httpServletRequest.getRemoteAddr());

    }

}

