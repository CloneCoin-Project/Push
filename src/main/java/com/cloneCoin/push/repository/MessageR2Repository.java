package com.cloneCoin.push.repository;

import com.cloneCoin.push.domain.Message;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface MessageR2Repository extends R2dbcRepository<Message, Long> {
}
