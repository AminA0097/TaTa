package com.userservice.tata.Message;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {
    private boolean sendMessage(MessageForm messageForm){
        return true;
    }
}
