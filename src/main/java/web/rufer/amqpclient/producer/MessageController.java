package web.rufer.amqpclient.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    protected MessageService messageService;

    @RequestMapping("/send")
    public void sendMessageToQueue(@RequestBody String message) {
        messageService.sendMsgToQueue(message);
    }
}
