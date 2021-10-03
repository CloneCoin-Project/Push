package com.cloneCoin.push.domain;

import com.cloneCoin.push.dto.SendMessageDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "messages")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    private Long userId;

    @Enumerated(EnumType.STRING)
    private Type type;

    private String message;
    private LocalDateTime receiveTime;

    public SendMessageDto toDto(){
        return SendMessageDto.builder()
                .userId(this.userId)
                .type(this.type)
                .msg(this.message)
                .receiveTime(this.receiveTime)
                .build();
    }
}
