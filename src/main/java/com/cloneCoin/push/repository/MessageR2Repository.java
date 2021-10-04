package com.cloneCoin.push.repository;

import com.cloneCoin.push.domain.Message;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;

public interface MessageR2Repository extends R2dbcRepository<Message, Long> {

    @Query(value = "select * from messages where leader_id=:leaderId and (user_id is null or user_id=:userId)")
    Flux<Message> findByLeaderId(@Param(value = "leaderId") Long leaderId, @Param(value = "userId") Long userId);
}

/**
 create table messages (
 message_id bigint not null auto_increment,
 leader_id bigint,
 message varchar(255),
 receive_time datetime,
 type varchar(255),
 user_id bigint,
 primary key (message_id)
 ) engine=InnoDB
 */