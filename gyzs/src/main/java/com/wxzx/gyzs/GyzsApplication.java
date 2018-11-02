package com.wxzx.gyzs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@ImportResource(locations = {"classpath:spring-beans.xml"})
public class GyzsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GyzsApplication.class, args);
	}
}
