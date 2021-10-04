package com.cloneCoin.push.dto;

import com.cloneCoin.push.domain.Type;
import lombok.Builder;
import lombok.Data;

@Data
public class ReceiveDto {

    private Long leaderId;

    private String type;
    private String message;

}