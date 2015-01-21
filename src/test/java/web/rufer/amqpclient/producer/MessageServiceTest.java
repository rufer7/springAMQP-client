package web.rufer.amqpclient.producer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.amqp.core.AmqpTemplate;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest {

    MessageService messageService;

    @Mock
    AmqpTemplate mockedRabbitTemplate;

    @Before
    public void init() {
        messageService = new MessageService();
        messageService.rabbitTemplate = mockedRabbitTemplate;
    }

    @Test
    public void sendMsgToQueueCallsRabbitTemplate() {
        messageService.sendMsgToQueue("testmsg");
        verify(mockedRabbitTemplate, times(1)).convertAndSend(anyString());
    }
}
