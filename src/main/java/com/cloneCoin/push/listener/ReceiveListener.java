package com.cloneCoin.push.listener;

import com.cloneCoin.push.domain.Message;
import com.cloneCoin.push.dto.ReceiveDto;
import com.cloneCoin.push.dto.SendMessageDto;
import com.cloneCoin.push.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveListener {

    private final MessageRepository messageRepository;
    private final SimpMessagingTemplate template;

    @KafkaListener(topics = "message-push", groupId = "foo")
    public void ReceiveListener(@Payload ReceiveDto receiveDto){
        Message message = Message.builder()
                .userId(receiveDto.getUserId())
                .type(receiveDto.getType())
                .message(receiveDto.getMessage())
                .receiveTime(LocalDateTime.now())
                .build();
        messageRepository.save(message);
        SendMessageDto msg = SendMessageDto.builder()
                .userId(receiveDto.getUserId())
                .type(receiveDto.getType())
                .msg(receiveDto.getMessage())
                .receiveTime(message.getReceiveTime())
                .build();
        template.convertAndSend("/topic/group/" + receiveDto.getUserId(), msg);
    }
}
