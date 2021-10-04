package com.cloneCoin.push.dto;

import lombok.Data;

@Data
public class FollowDto {

    private Long leaderId;
    private Long userId;
    private String leaderName;
    private String userName;
    private String type;
}
