package com.cloneCoin.push.listener;

import com.cloneCoin.push.domain.Message;
import com.cloneCoin.push.domain.Type;
import com.cloneCoin.push.dto.FollowDto;
import com.cloneCoin.push.dto.ReceiveDto;
import com.cloneCoin.push.dto.SendMessageDto;
//import com.cloneCoin.push.repository.MessageRepository;
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

//    private final MessageRepository messageRepository;
    private final SimpMessagingTemplate template;

//    @KafkaListener(topics = "message-push", groupId = "foo", containerFactory = "kafkaListenerContainerFactory")
//    public void ReceiveListener(ReceiveDto receiveDto){
//        String type = "";
//        if(receiveDto.getType().equals("BOUGHT")){
//            type = "BOUGHT";
//        }else{
//            type = "SOLD";
//        }
//        Message message = Message.builder()
//                .leaderId(receiveDto.getLeaderId())
//                .type(type)
//                .message(receiveDto.getMessage())
//                .receiveTime(LocalDateTime.now())
//                .build();
//
//        messageRepository.save(message);
//
//        SendMessageDto msg = SendMessageDto.builder()
//                .userId(receiveDto.getLeaderId())
//                .type(receiveDto.getType())
//                .msg(receiveDto.getMessage())
//                .receiveTime(message.getReceiveTime())
//                .build();
//
//        template.convertAndSend("/topic/group/" + receiveDto.getLeaderId(), msg);
//    }
//
//    @KafkaListener(topics = "follow-topic", groupId = "foo", containerFactory = "kafkaListenerContainerFactory1")
//    public void followListener(@Payload FollowDto followDto){
//        if (followDto.getType().equals("follow")) {
//            String msg = followDto.getUserName() + "님이 " + followDto.getLeaderName() + "님을 팔로우 하였습니다.";
//            Message message = Message.builder()
//                    .leaderId(followDto.getLeaderId())
//                    .userId(followDto.getUserId())
//                    .type(followDto.getType())
//                    .message(msg)
//                    .receiveTime(LocalDateTime.now())
//                    .build();
//            messageRepository.save(message);
//        } else if(followDto.getType().equals("unfollow")){
//            String msg = followDto.getUserId() + "님이 " + followDto.getLeaderId() + "님을 언팔로우 하였습니다.";
//            Message message = Message.builder()
//                    .leaderId(followDto.getLeaderId())
//                    .userId(followDto.getUserId())
//                    .type(followDto.getType())
//                    .message(msg)
//                    .receiveTime(LocalDateTime.now())
//                    .build();
//            messageRepository.save(message);
//        }
//    }
}
