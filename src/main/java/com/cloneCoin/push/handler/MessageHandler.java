package com.cloneCoin.push.handler;

import com.cloneCoin.push.domain.Message;
import com.cloneCoin.push.dto.InfoDto;
import com.cloneCoin.push.dto.SendMessageDto;
import com.cloneCoin.push.repository.MessageR2Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageHandler {

    private final MessageR2Repository messageR2Repository;

    public Mono<List<SendMessageDto>> getPrevious(InfoDto infoDto){
        AtomicBoolean isTrue = new AtomicBoolean(false);
        return messageR2Repository.findByLeaderId(infoDto.getLeaderId(), infoDto.getUserId())
                .map(message -> {
                    Message m = new Message("NULL");
                    if (message.getType().equals("follow")) {
                        isTrue.set(true);
                        m = message;
                    }
                    if (message.getType().equals("unfollow")) {
                        m = message;
                        isTrue.set(false);
                    }
                    if (isTrue.get() == true) {
                        m = message;
                    }
                    return m;
                })
                .filter(message -> !message.getType().equals("NULL"))
                .collectList().map(messages1 -> toDtoList(messages1));
    }

    private List<SendMessageDto> toDtoList(List<Message> messageList){
        return messageList.stream()
                .map(message -> message.toDto()).collect(Collectors.toList());
    }
}
