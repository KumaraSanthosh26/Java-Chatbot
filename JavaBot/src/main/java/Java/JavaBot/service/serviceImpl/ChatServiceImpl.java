package Java.JavaBot.service.serviceImpl;

import Java.JavaBot.model.Intent;
import Java.JavaBot.service.ChatService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    private List<Intent> intents;

    @PostConstruct
    public void loadIntents() {
        try {
            File file = ResourceUtils.getFile("classpath:intents.json");
            ObjectMapper objectMapper = new ObjectMapper();
            intents = objectMapper.readValue(file, new TypeReference<List<Intent>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            intents = new ArrayList<>();
        }
    }

    @Override
    public String getResponse(String userMessage) {
        for (Intent intent : intents) {
            for (String pattern : intent.getPatterns()) {
                if (userMessage.equalsIgnoreCase(pattern)) {
                    return intent.getResponse().get(0);
                }
            }
        }
        return "I'm sorry, I didn't understand that.";
    }
}
