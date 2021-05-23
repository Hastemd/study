package com.hastemd.demo;

import com.hastemd.demo.aop.service.impl.TestInsertServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableTransactionManagement
//@EnableAspectJAutoProxy
@MapperScan(basePackages = {"com.hastemd.demo.**.dao"}, annotationClass = Repository.class)
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
		Object bean = applicationContext.getBean(TestInsertServiceImpl.class);
	}

}
