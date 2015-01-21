package web.rufer.amqpclient.producer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MessageControllerTest {

    MessageController messageController;

    @Mock
    MessageService mockedMessageService;

    @Before
    public void init() {
        messageController = new MessageController();
        messageController.messageService = mockedMessageService;
    }

    @Test
    public void sendMessageToQueueCallsMessageService() {
        messageController.sendMessageToQueue("test");
        verify(mockedMessageService, times(1)).sendMsgToQueue(anyString());
    }
}
