package com.edu.hit.raffle.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.edu.hit.raffle.common.ExcelUtils;
import com.edu.hit.raffle.common.Result;
import com.edu.hit.raffle.pojo.User;
import com.edu.hit.raffle.service.Impl.UserServiceImpl;
import com.edu.hit.raffle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 检查用户是否有抽奖资格
     */
    @GetMapping("/check")
    public Result<String> check(String name,String phone){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(User::getName,name);
        lambdaQueryWrapper.eq(User::getPhone,phone);
        User user = userService.getOne(lambdaQueryWrapper);

        if(user==null){
            return Result.error("用户不存在");
        }
        if (user.getParticipated() ==1){
            return Result.error("已抽奖");
        }
        return Result.success("通过验证");
    }

    /**
     * 通过excel导入用户
     */
    @PostMapping("/import")
    public Result<String> importUser(MultipartFile file){
        String fileName = file.getOriginalFilename();
        if (fileName.endsWith(".xlsx")){
            List<User> orders = ExcelUtils.excelToOrderForXlsx(file);
            userService.saveBatch(orders);
        }else if (fileName.endsWith(".xls")){
            List<User> orders = ExcelUtils.excelToOrderForXls(file);
            userService.saveBatch(orders);
        }
        else {
            return Result.error("文件格式错误");
        }

        return Result.success("导入成功");
    }

    /**
     * 增删改查
     * @param user
     * @return
     */
    @PostMapping("/add")
    public Result<User> add(User user){
        userService.save(user);
        return Result.success(user);
    }
    @DeleteMapping("/delete")
    public Result<String> delete(int id){
        userService.removeById(id);
        return Result.success("删除成功");
    }
    @PutMapping("/update")
    public Result<User> update(User user){
        userService.updateById(user);
        return Result.success(user);
    }
    @GetMapping("/list")
    public Result<List<User>> list(){
        List<User> list = userService.list();
        return Result.success(list);
    }
}
