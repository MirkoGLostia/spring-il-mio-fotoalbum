package com.example.demo.service;

import com.example.demo.model.Message;
import com.example.demo.model.User;
import com.example.demo.repository.MessageRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message saveMessage(Message mex) {
        mex.setId(null);
        mex.setReadMex(true);
        return messageRepository.save(mex);
    }

    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

}
