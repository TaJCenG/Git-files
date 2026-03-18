package com.sprBoot.student.service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import feign.Feign;

@LoadBalancerClient(value="ADDRESSSERVICE")
public class LoadBalanceConfig {

	@LoadBalanced
	@Bean
	public Feign.Builder feignBuilder(){
		return Feign.builder();
	}
}
