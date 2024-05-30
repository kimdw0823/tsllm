package com.example.backend.service.trade.impl;

import com.example.backend.data.dao.AutoTradeDao;
import com.example.backend.data.dao.OrderDao;
import com.example.backend.data.dto.trade.AutoTradeDto;
import com.example.backend.data.dto.trade.OrderDto;
import com.example.backend.data.entity.trading.AutoTrade;
import com.example.backend.data.entity.trading.Order;
import com.example.backend.service.trade.TradeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TradeServiceImpl implements TradeService {
    private final AutoTradeDao autoTradeDao;
    private final OrderDao orderDao;
    private final ModelMapper modelMapper;

    @Autowired
    public TradeServiceImpl(AutoTradeDao autoTradeDao, OrderDao orderDao, ModelMapper modelMapper) {
        this.autoTradeDao = autoTradeDao;
        this.orderDao = orderDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AutoTradeDto> findAutoTrade(Long userId){
        List<AutoTrade> autoTrades = autoTradeDao.findUserId(userId,"open");
        return autoTrades.stream()
                .map(autoTrade -> modelMapper.map(autoTrade, AutoTradeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findOrder(Long userId){
        List<Order> orders = orderDao.findOrder(userId);

        return orders.stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findCompleteOrder(Long userId){
        List<Order> orders = orderDao.findCompleteOrder(userId, "complete");

        return orders.stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }
}
