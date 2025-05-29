package com.userservice.tata.Message;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @PostMapping("/sendmessage")
    public boolean sendMessage(MessageForm messageForm){
        return true;
    }
    @GetMapping("/getmessage")
    public List<MessageDto> getMessage(){
        return null;
    }
    @GetMapping("/showdetail")
    public List<MessageDto> getMessageDetail(String messageId){
        return null;
    }
    @PostMapping("/updatemessage")
    public boolean updateMessage(MessageForm messageForm){
        return true;
    }
}
