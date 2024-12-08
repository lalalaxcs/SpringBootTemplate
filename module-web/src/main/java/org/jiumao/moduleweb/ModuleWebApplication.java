package org.jiumao.moduleweb;

import org.jiumao.moduleweb.config.JacksonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(JacksonConfig.class)
@EnableCaching
public class ModuleWebApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(ModuleWebApplication.class, args);
		Object objectMapper = run.getBean("objectMapper");
	}

}
