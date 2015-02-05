package com.currencyfair.test.services;

import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.currencyfair.database.model.MoneyTransaction;
import com.currencyfair.database.model.User;
import com.currencyfair.database.model.support.CurrencySupport;
import com.currencyfair.database.repositories.MoneyTransactionRepository;
import com.currencyfair.database.repositories.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration(value = "classpath:/application-context-test.xml")
public class MoneyTransactionRepositoryTest {
    @Autowired
    private MoneyTransactionRepository moneyTransactionRepository;
    @Autowired
    private UserRepository UserRepository;

    @Test
    public void testSaveTransaction() {
        User user = new User();
        user.setId(54332);
        user.setName("UNKNOWN");
        UserRepository.save(user);
        Date now = new Date();
        MoneyTransaction mt = new MoneyTransaction();
        mt.setUser(user);
        mt.setAmountBuy(BigInteger.valueOf(123l));
        mt.setAmountSell(BigInteger.valueOf(12l));
        mt.setCurrencyFrom(CurrencySupport.EUR);
        mt.setCurrencyTo(CurrencySupport.USD);
        mt.setOriginatingCountry("EIR");
        mt.setRate(12.3);
        mt.setTimePlaced(new Timestamp(now.getDate()));

        moneyTransactionRepository.save(mt);
        assertNotNull(mt.getId());

    }

}
