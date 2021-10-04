package com.cloneCoin.push.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class InfoDto {

    private Long userId;
    private Long leaderId;
}
