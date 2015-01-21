package web.rufer.amqpclient.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendMsgToQueue(String message) {
        rabbitTemplate.convertAndSend(message);
    }
}
