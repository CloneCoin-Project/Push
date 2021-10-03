package com.cloneCoin.push.service;

import com.cloneCoin.push.domain.Message;
import com.cloneCoin.push.dto.InfoDto;
import com.cloneCoin.push.dto.SendMessageDto;
import com.cloneCoin.push.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {

    private final MessageRepository messageRepository;

    public List<SendMessageDto> getPrevious(InfoDto infoDto){
        List<Message> messageList = messageRepository.findByUserId(infoDto.getUserId(), infoDto.getSendTime());
        messageList.stream()
                .forEach(message -> {
                    log.info("123123"+message.getMessage());
                });
        log.info("123123123123123"+messageList.get(0).getMessage());
        return toDtoList(messageList);
    }

    private List<SendMessageDto> toDtoList(List<Message> messageList){
        return messageList.stream()
                .map(message -> message.toDto()).collect(Collectors.toList());
    }
}
