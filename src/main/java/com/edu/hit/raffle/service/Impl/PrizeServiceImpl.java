package com.edu.hit.raffle.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.hit.raffle.mapper.PrizeMapper;
import com.edu.hit.raffle.pojo.Prize;
import com.edu.hit.raffle.service.PrizeService;
import org.springframework.stereotype.Service;

@Service
public class PrizeServiceImpl extends ServiceImpl<PrizeMapper, Prize> implements PrizeService {
}
