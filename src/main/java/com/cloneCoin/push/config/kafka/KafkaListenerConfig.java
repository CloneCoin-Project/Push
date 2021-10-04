package com.cloneCoin.push.config.kafka;

import com.cloneCoin.push.dto.FollowDto;
import com.cloneCoin.push.dto.ReceiveDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
@Slf4j
public class KafkaListenerConfig {

    @Bean
    ConcurrentKafkaListenerContainerFactory<String, ReceiveDto> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ReceiveDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setErrorHandler(((e, consumerRecord) ->{
            log.info("=== " + consumerRecord.value());
            log.error("error : "+ e);
            log.info("잘못된 형식이 들어왔습니다.");
        }));

        return factory;
    }

    @Bean
    ConcurrentKafkaListenerContainerFactory<String, FollowDto> kafkaListenerContainerFactory1() {
        ConcurrentKafkaListenerContainerFactory<String, FollowDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory1());
        factory.setErrorHandler(((e, consumerRecord) ->{
            log.info("=="+consumerRecord.value());
            log.error("error : "+ e);
            log.info("잘못된 형식이 들어왔습니다.");
        }));

        return factory;
    }

    @Bean
    public ConsumerFactory<String, FollowDto> consumerFactory1() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigurations(), new StringDeserializer(),
                new ErrorHandlingDeserializer(new JsonDeserializer<>(FollowDto.class)));

    }

    @Bean
    public ConsumerFactory<String, ReceiveDto> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigurations(), new StringDeserializer(),
                new ErrorHandlingDeserializer(new JsonDeserializer<>(ReceiveDto.class)));
    }

    @Bean
    public Map<String, Object> consumerConfigurations() {
        JsonDeserializer<Object> deserializer = new JsonDeserializer<>(Object.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);

        Map<String, Object> configurations = new HashMap<>();
        configurations.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.KAFKA_BROKER);
        configurations.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstants.GROUP_ID);
        configurations.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configurations.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);
        configurations.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        configurations.put(JsonDeserializer.TRUSTED_PACKAGES, "*");

        return configurations;
    }
}