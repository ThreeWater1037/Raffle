package com.edu.hit.raffle.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Prize {
    @TableId(value="id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private int stock;
    private double probability;
    private String image;
}
