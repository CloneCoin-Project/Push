package com.cloneCoin.push.repository;

import com.cloneCoin.push.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value = "select * from messages where user_id=:id and receive_time >= :time", nativeQuery = true)
    List<Message> findByUserId(@Param(value = "id") Long userId, @Param(value = "time") LocalDateTime localDateTime);
}
