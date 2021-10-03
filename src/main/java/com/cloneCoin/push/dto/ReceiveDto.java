package com.cloneCoin.push.dto;

import com.cloneCoin.push.domain.Type;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class ReceiveDto {

    private Long userId;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String message;
}
