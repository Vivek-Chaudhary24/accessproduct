package dev.Vivek.product.Services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
@KafkaListener(topics="user-registration",groupId="product-service-group")
public void Consumer(String message) {
System.out.println("Received message:"+message);
    }

 @KafkaListener(topics="login-id",groupId = "product-service-group")
 public void Consum(String message) {
    System.out.println("Received message:"+message);
 }
}
