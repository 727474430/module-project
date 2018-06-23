package com.raindrop.module;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @name: com.raindrop.module.ModuleWebApplication.java
 * @description: 启动类
 * @author: Wang Liang 
 * @create Time: 2018/6/21 17:27
 * pyright: 深圳拖保软件有限公司
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.raindrop.module.dao")
public class ModuleWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuleWebApplication.class, args);
	}

}
