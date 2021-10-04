package com.cloneCoin.push.dto;

import com.cloneCoin.push.domain.Message;
import com.cloneCoin.push.domain.Type;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class SendMessageDto {

    private Long userId;
    private String type;
    private String msg;
    private LocalDateTime receiveTime;

    @Builder
    public SendMessageDto(Long userId, String type, String msg, LocalDateTime receiveTime) {
        this.userId = userId;
        this.type = type;
        this.msg = msg;
        this.receiveTime = receiveTime;
    }

}
