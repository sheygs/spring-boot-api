package com.sheygs;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AIService {
    private final ChatClient chatClient;

    public AIService(ChatClient.Builder builder){
       this.chatClient = builder.build();
    }

    public String chat(String prompt) {
        return this.chatClient
                .prompt(prompt)
                .call()
                .content();
    }
}
