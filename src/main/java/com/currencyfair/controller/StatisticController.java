package com.currencyfair.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.currencyfair.services.MoneyTransactionService;

@Controller
@RequestMapping("/statistics")
public class StatisticController {

    @Autowired
    private MoneyTransactionService moneyTransactionService;

    @RequestMapping(method = RequestMethod.GET)
    public String printStatistics(ModelMap model) {
        model.addAttribute("allTransactions", moneyTransactionService.findAllOrderByUserOrderByUserAsc());
        model.addAttribute("transactionByCurrency", moneyTransactionService.findAllGroupByCurrency());
        return "statistics";
    }

}
