package com.xzf.spring.cloud.zuul.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulApplication {

	@Autowired
	private ZuulProperties zuulProperties;

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}

	@Bean
	public PatternServiceRouteMapper serviceRouteMapper() {
		return new PatternServiceRouteMapper("(?<name>^.+)-(center)", "/${name}-api/**"){
			@Override
			public String apply(final String serviceId) {
				String route =  super.apply(serviceId);
				System.out.println("---prefix--->"+zuulProperties.getPrefix()+"--stripprefix--"+zuulProperties.isStripPrefix());
				System.out.println(serviceId + " --------------------> " +route);
				return route;
			}
		};
	}




}
