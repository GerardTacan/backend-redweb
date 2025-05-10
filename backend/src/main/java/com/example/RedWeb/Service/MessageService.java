package com.example.RedWeb.Service;

import com.example.RedWeb.Entity.MessageEntity;
import com.example.RedWeb.Repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public void sendMessage(String senderEmail, String receiverEmail, String content) {
        MessageEntity message = new MessageEntity();
        message.setSenderEmail(senderEmail);
        message.setReceiverEmail(receiverEmail);
        message.setContent(content);

        messageRepository.save(message);
    }

    public List<MessageEntity> getMessages(String userEmail) {
        return messageRepository.findBySenderEmailOrReceiverEmail(userEmail, userEmail);
    }
}