package com.cloneCoin.push.domain;

import com.cloneCoin.push.dto.SendMessageDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Data
@Table(value = "messages")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @Column(value = "message_id")
    private Long id;
    @Column
    private Long leaderId;
    @Column
    private Long userId;
    @Column
    private String type;
    @Column
    private String message;
    @Column
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
