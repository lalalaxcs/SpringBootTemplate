package org.jiumao.moduleweb.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.jiumao.moduleweb.storeorder.domain.vo.converter.CusMoneySerializer;
import org.jiumao.moduleweb.storeorder.domain.vo.embed.CusMoney;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/3 21:46]
 */
@Configuration
public class JacksonConfig {
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleModule module = new SimpleModule();
		module.addSerializer(CusMoney.class, new CusMoneySerializer());  // 替换默认的 Money 序列化器
		objectMapper.registerModule(module);
		return objectMapper;
	}
}
