package com.amr.ctx.user.user_context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan({"com.amr.comm.bsns.common_business.*"})
public class UserContext {

	public static void main(String[] args) {
		SpringApplication.run(UserContext.class, args);
	}

}
