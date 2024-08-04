package com.wipro.flight.producer;

import com.wipro.flight.dto.BookingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookingProducer {


    @Autowired
    private KafkaTemplate<String, BookingInfo> kafkaTemplate;

    public void sendMessage(String topic, BookingInfo bookingInfo) {
        kafkaTemplate.send(topic, bookingInfo);
    }

}
