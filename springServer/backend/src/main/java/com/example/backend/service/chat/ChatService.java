package com.example.backend.service.chat;

import com.example.backend.data.dto.chat.ChatDto;
import com.example.backend.data.dto.chat.LlmChatDto;
import com.example.backend.data.dto.chat.UserChatDto;

import java.util.List;

public interface ChatService {
    List<ChatDto> getChatList(Long userId);

    void deleteChat(Long chatId) throws Exception;

    List<UserChatDto> getUserChat(Long userId, Long chatId);

    List<LlmChatDto> getLlmChat(Long userId, Long chatId);

    ChatDto updateChatTitle(Long chatId, String title) throws Exception;

    LlmChatDto requestLlm(Long userId, String input) throws Exception;
}
