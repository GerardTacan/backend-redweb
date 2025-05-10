package com.example.RedWeb.Controller;

import com.example.RedWeb.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    // Endpoint to send a message
    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam String senderEmail, @RequestParam String receiverEmail,
                                              @RequestParam String content) {
        messageService.sendMessage(senderEmail, receiverEmail, content);
        return ResponseEntity.ok("Message sent successfully");
    }

    // Endpoint to get messages for a user
    @GetMapping("/user/{email}")
    public ResponseEntity<List<?>> getMessages(@PathVariable String email) {
        List<?> messages = messageService.getMessages(email);
        return ResponseEntity.ok(messages);
    }
}