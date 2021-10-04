package com.cloneCoin.push.repository;

import com.cloneCoin.push.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value = "select * from messages where leader_id=:leaderId and (user_id is null or user_id=:userId)", nativeQuery = true)
    List<Message> findByLeaderId(@Param(value = "leaderId") Long leaderId, @Param(value = "userId") Long userId);
}
