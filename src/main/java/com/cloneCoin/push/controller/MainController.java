package com.cloneCoin.push.controller;

import com.cloneCoin.push.domain.Message;
import com.cloneCoin.push.dto.InfoDto;
import com.cloneCoin.push.dto.SendMessageDto;
import com.cloneCoin.push.handler.MessageHandler;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/push")
@RequiredArgsConstructor
public class MainController {

    private final MessageHandler messageHandler;

    @GetMapping("/welcome")
    public String Main(){
        return "Hello Push Server";
    }

    @PostMapping("/previous")
    public Mono<List<SendMessageDto>> getPrevious(@RequestBody InfoDto infoDto){
        return messageHandler.getPrevious(infoDto);
    }
}
