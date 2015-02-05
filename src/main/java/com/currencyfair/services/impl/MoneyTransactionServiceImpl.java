package com.currencyfair.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.currencyfair.database.model.MoneyTransaction;
import com.currencyfair.database.repositories.MoneyTransactionRepository;
import com.currencyfair.services.MoneyTransactionService;

@Service
@Transactional(readOnly = true)
public class MoneyTransactionServiceImpl implements MoneyTransactionService {

    @Autowired
    private MoneyTransactionRepository moneyTransactionRepository;

    @Override
    public List<MoneyTransaction> findAllOrderByUserOrderByUserAsc() {
        return moneyTransactionRepository.findAllOrderByUserOrderByUserAsc();
    }

    @Override
    public List<Object> findAllGroupByCurrency() {
        return moneyTransactionRepository.findAllGroupByCurrency();
    }

}
