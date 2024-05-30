package com.example.backend.service.user;

import com.example.backend.data.dto.user.ApiKeyDto;
import com.example.backend.data.dto.user.JoinDto;
import com.example.backend.data.dto.user.JoinResponseDto;

public interface JoinService {
    JoinResponseDto JoinProcess(JoinDto joinDto);

    ApiKeyDto updateApiKey(ApiKeyDto apiKeyDto) throws Exception;
}
