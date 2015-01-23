/*
 * Copyright (C) 2015 Marc Rufer (m.rufer@gmx.ch)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
public class MessageProducerControllerTest {

    MessageProducerController messageProducerController;

    @Mock
    MessageProducerService mockedMessageProducerService;

    @Before
    public void init() {
        messageProducerController = new MessageProducerController();
        messageProducerController.messageProducerService = mockedMessageProducerService;
    }

    @Test
    public void sendMessageToQueueCallsMessageService() {
        messageProducerController.sendMessageToQueue("test");
        verify(mockedMessageProducerService, times(1)).sendMsgToQueue(anyString());
    }
}
