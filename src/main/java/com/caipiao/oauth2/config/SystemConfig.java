package com.caipiao.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations={"classpath:spring-mybatis.xml","spring.xml"})
public class SystemConfig {

}
