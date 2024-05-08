package com.example.backend.restTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatTest {
    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper;

    private final static String url = "https://www.chatbase.co/api/v1/chat";

    private final static String apiKey = "55206f15-e40c-44b9-b922-908bff529fe8";

    private final static String chatbotId = "QRJXiSmHFCw9sRntSBxCb";

    @Autowired
    public ChatTest(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public ResponseEntity<String> RequestToModel (String message){
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("chatbotId", chatbotId);
        requestBody.put("stream", false);
        requestBody.put("temperature", 0);
        requestBody.put("conversationId",1);

        List<Map<String, String>> messages = new ArrayList<>();
        Map<String, String> message1 = new HashMap<>();
        message1.put("content", "How can I help you?");
        message1.put("role", "assistant");
        messages.add(message1);
        Map<String, String> message2 = new HashMap<>();
        message2.put("content", message);
        message2.put("role", "user");
        messages.add(message2);
        requestBody.put("messages", messages);

        String requestBodyJson = null;
        try {
            requestBodyJson = objectMapper.writeValueAsString(requestBody);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // HTTP 요청 설정
        HttpEntity<String> entity = new HttpEntity<>(requestBodyJson, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        return response;
    }
}
