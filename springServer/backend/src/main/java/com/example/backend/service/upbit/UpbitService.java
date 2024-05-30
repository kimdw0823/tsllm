package com.example.backend.service.upbit;

import com.example.backend.data.dto.upbit.AccountDto;
import com.example.backend.data.dto.upbit.HistoryDto;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UpbitService {
    List<AccountDto> getAccount(Long id);

    List<HistoryDto> getHistory(Long id) throws UnsupportedEncodingException, NoSuchAlgorithmException;
}
