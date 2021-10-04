package com.cloneCoin.push.dto;

import com.cloneCoin.push.domain.Type;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class ReceiveDto {

    private Long leaderId;

    private String type;
    private String message;

}