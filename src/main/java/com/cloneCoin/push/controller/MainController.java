package com.cloneCoin.push.controller;

import com.cloneCoin.push.domain.Message;
import com.cloneCoin.push.dto.InfoDto;
import com.cloneCoin.push.dto.SendMessageDto;
import com.cloneCoin.push.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/push")
@RequiredArgsConstructor
public class MainController {

    private final MessageService messageService;

    @GetMapping("/welcome")
    public String Main(){
        return "Hello Push Server";
    }

    @PostMapping("/previous")
    public List<SendMessageDto> getPrevious(@RequestBody InfoDto infoDto){
        return messageService.getPrevious(infoDto);
    }
}
