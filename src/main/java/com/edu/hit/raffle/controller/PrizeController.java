package com.edu.hit.raffle.controller;


import com.edu.hit.raffle.common.Result;
import com.edu.hit.raffle.pojo.Prize;
import com.edu.hit.raffle.pojo.User;
import com.edu.hit.raffle.service.PrizeService;
import com.edu.hit.raffle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prize")
public class PrizeController{
    @Autowired
    private PrizeService prizeService;
    private UserService userService;

    /**
     * 新增奖品
     * @param prize
     * @return
     */
    @PostMapping("")
    public Result<Prize> save(Prize prize){
        prizeService.save(prize);
        return Result.success(prize);
    }

    /**
     * 删除奖品
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public Result<String> delete(int id){
        prizeService.removeById(id);
        return Result.success("删除成功");
    }

    /**
     * 修改奖品
     * @param prize
     * @return
     */
    @PostMapping("/update")
    public Result<Prize> update(Prize prize){
        prizeService.updateById(prize);
        return Result.success(prize);
    }

    /**
     * 奖品列表
     * @return
     */
    @GetMapping("/list")
    public Result<List<Prize>> list(){
        List<Prize> list = prizeService.list();
        return Result.success(list);
    }

    /**
     * 抽奖
     * @return
     */
    @GetMapping("/win")
    public Result<Prize> win(@RequestBody Prize prize,@RequestBody User user){
        if (prize.getStock()<=0){
            return Result.error("奖品已抽完");
        }
        prize.setStock(prize.getStock()-1);
        prizeService.updateById(prize);
        user.setParticipated(1);
        userService.updateById(user);
        return Result.success(prize);
    }
}
