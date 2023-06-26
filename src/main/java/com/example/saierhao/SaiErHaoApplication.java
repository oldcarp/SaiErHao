package com.example.saierhao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.saierhao.generator.mapper")
public class SaiErHaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaiErHaoApplication.class, args);
    }

}
