package com.madorb
import groovy.util.logging.Slf4j

import org.springframework.boot.SpringApplication
import org.springframework.boot.actuate.autoconfigure.ManagementSecurityAutoConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Configuration

/**
 * Spring Boot "Magic" class
 */
@Configuration
//The below disable appears to make no difference...
@EnableAutoConfiguration(exclude=[SecurityAutoConfiguration.class, ManagementSecurityAutoConfiguration.class])
@Slf4j
public class BaseApplicationConfig {

	def static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BaseApplicationConfig.class, args)

		log.trace("All wired beans: ")
		String[] beanNames = ctx.getBeanDefinitionNames()
		Arrays.sort(beanNames)
		beanNames.each { String it -> log.trace(it) }
	}
}