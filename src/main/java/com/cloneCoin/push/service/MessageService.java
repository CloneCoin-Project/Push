package com.cloneCoin.push.service;

import com.cloneCoin.push.domain.Message;
import com.cloneCoin.push.domain.Type;
import com.cloneCoin.push.dto.InfoDto;
import com.cloneCoin.push.dto.SendMessageDto;
import com.cloneCoin.push.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {

    private final MessageRepository messageRepository;

    public List<SendMessageDto> getPrevious(InfoDto infoDto){
        List<Message> messageList = messageRepository.findByLeaderId(infoDto.getLeaderId(), infoDto.getUserId());
        List<Message> messages = new ArrayList<>();
        boolean isTrue = false;
        for (Message m:messageList) {
            if(m.getType().equals("follow")){
                isTrue = true;
            }
            if(m.getType().equals("unfollow")){
                messages.add(m);
                isTrue = false;
            }
            if(isTrue == true){
                messages.add(m);
            }
        }
        List<SendMessageDto> sendMessageDtos = toDtoList(messages);
        return sendMessageDtos;
    }

    private List<SendMessageDto> toDtoList(List<Message> messageList){
        return messageList.stream()
                .map(message -> message.toDto()).collect(Collectors.toList());
    }
}
