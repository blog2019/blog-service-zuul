package com.blog.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class BlogServiceZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogServiceZuulApplication.class, args);
	}

}

