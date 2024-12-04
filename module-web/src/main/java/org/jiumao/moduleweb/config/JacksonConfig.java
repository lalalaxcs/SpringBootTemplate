package org.jiumao.moduleweb.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.jiumao.moduleweb.storeorder.domain.vo.converter.MoneyDeserializer;
import org.jiumao.moduleweb.storeorder.domain.vo.converter.MoneySerializer;
import org.joda.money.Money;
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
		// 注册 JodaModule 以处理 Joda-Money 的序列化
		objectMapper.registerModule(new JodaModule());

		// 注册自定义的 MoneySerializer
		SimpleModule module = new SimpleModule();
		module.addSerializer(Money.class, new MoneySerializer());  // 替换默认的 Money 序列化器
		objectMapper.registerModule(module);
		return objectMapper;
	}
}
