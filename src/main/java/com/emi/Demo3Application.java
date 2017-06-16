package com.emi;

import com.emi.config.SystemProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@SpringBootApplication
@EnableJpaAuditing
//@MapperScan(basePackages = {"com.emi.repository.mapper","org.springframework.boot.autoconfigure.web.DefaultErrorViewResolver"})
@MapperScan("com.emi.repository.mapper")
@EnableConfigurationProperties(SystemProperties.class)
public class Demo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
	}
}
