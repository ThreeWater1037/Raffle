package com.edu.hit.raffle.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.hit.raffle.mapper.UserMapper;
import com.edu.hit.raffle.pojo.User;
import com.edu.hit.raffle.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
}
