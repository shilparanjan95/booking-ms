package com.wipro.flight.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.flight.dto.BookingInfo;
import com.wipro.flight.producer.BookingProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BookingConsumer {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    BookingProducer bookingProducer;

    @KafkaListener(topics = "t1", groupId = "booking")
    public void listen(String message) throws JsonProcessingException {
        log.info("Received bookingInfo :  {} on topic t1 ",message);
        BookingInfo bookingInfo = objectMapper.readValue(message, BookingInfo.class);
        bookingInfo.setStatus("Successful");
        log.info("Sending bookingInfo:  {} on topic t2 ",bookingInfo);
        bookingProducer.sendMessage("t2",bookingInfo);

    }


}
