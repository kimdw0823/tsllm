package com.example.backend.data.dto.chat;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class ChatRequestDto {

    private Long chatId;
}
