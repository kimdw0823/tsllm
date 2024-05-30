package com.example.backend.service.trade;

import com.example.backend.data.dto.trade.AutoTradeDto;
import com.example.backend.data.dto.trade.OrderDto;

import java.util.List;

public interface TradeService {
    List<AutoTradeDto> findAutoTrade(Long userId);

    List<OrderDto> findOrder(Long userId);

    List<OrderDto> findCompleteOrder(Long userId);
}
