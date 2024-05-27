package Java.JavaBot.controller;

import Java.JavaBot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @PostMapping("/chatResponse")
    public String chat(@RequestBody String userMessage) {
        String response = chatService.getResponse(userMessage);
        return response;
    }
}
