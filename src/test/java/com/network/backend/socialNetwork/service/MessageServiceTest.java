package com.network.backend.socialNetwork.service;

import com.network.backend.model.Message;
import com.network.backend.model.Users;
import com.network.backend.service.MessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class MessageServiceTest {
    @MockBean
    private MessageService messageService;

    private Message getMessage(){
        Message message=new Message();
        message.setMessage("test");
        message.setId(1);
        message.setReceiver(new Users());
        message.setSender(new Users());
        return message;
    }

    @Test
    public void testCreateMessage(){
        Message message=getMessage();
        when(messageService.saveMessage(any(Message.class))).thenReturn(message);
        Message message1=messageService.saveMessage(message);
        assertThat(!message1.getMessage().isBlank());
    }

    @Test
    public void testUpdateMessage(){
        Message message=getMessage();
        when(messageService.updateMessage(any(Message.class))).thenReturn(message);
        Message message1=messageService.updateMessage(message);
        assertThat(!message1.getMessage().isBlank());
    }

    @Test
    public void testDeleteMessage(){
        doNothing().when(messageService).deleteMessage(1);
        messageService.deleteMessage(1);
        assertThat(true);
    }

    @Test
    public void testGetMessage(){
        Message message=getMessage();
        given(messageService.getMessage(1)).willReturn(message);
        Message result=messageService.getMessage(1);
        assertEquals(result.getId(),1);
    }

    @Test
    public void testGetMessageById(){
        Message message = getMessage();
        Users users=new Users();
        users.setId(5);
        List<Message> messageList = new ArrayList<>();
        messageList.add(message);
        given(messageService.getMassagesByUserId(users,12,1,"id")).willReturn((Page<Message>) messageList);
        Page<Message> result = messageService.getMassagesByUserId(users,12,1,"id");
        assertEquals(result.stream().count(), 1);
    }
}
