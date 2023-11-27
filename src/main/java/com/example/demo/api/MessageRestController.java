package com.example.demo.api;

import com.example.demo.model.Message;
import com.example.demo.model.User;
import com.example.demo.service.MessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/message")
@CrossOrigin
public class MessageRestController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/create")
    public Message createMessage(@Valid @RequestBody Message mex) {
        return messageService.saveMessage(mex);
    }

}
