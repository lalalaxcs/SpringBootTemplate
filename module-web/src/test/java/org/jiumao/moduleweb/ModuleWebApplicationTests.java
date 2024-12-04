package org.jiumao.moduleweb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest

class ModuleWebApplicationTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void contextLoads() {
	}

	@Test
	public void testSerialization() throws JsonProcessingException {
		Money money = Money.of(CurrencyUnit.of("CNY"), BigDecimal.valueOf(100.00));
		String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(money);
		System.out.println(json);
	}
}
