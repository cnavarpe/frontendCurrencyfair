package com.currencyfair.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.currencyfair.database.repositories.UserRepository;
import com.currencyfair.services.UserService;

@Service
@Transactional(readOnly = false)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

}
