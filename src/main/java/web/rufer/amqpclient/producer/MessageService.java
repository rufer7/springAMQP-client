package web.rufer.amqpclient.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    AmqpTemplate rabbitTemplate;

    public void sendMsgToQueue(String message) {
        rabbitTemplate.convertAndSend(message);
    }
}
