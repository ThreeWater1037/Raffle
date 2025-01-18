package com.edu.hit.raffle;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.edu.hit.raffle.mapper")
public class RaffleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RaffleApplication.class, args);
    }

}
