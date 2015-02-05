package com.currencyfair.services;

import java.util.List;

import com.currencyfair.database.model.MoneyTransaction;

public interface MoneyTransactionService {

    List<MoneyTransaction> findAllOrderByUserOrderByUserAsc();

    List<Object> findAllGroupByCurrency();

}
