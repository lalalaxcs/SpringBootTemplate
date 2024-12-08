package org.jiumao.moduleweb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

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

	@Test
	public void passwordTest(){
		String inputPassword = "mySecretPassword";
		String dataPassword = "JDJhJDEwJFZRYWg5d1VKdGl5QVNkclVWUWo3U09PTzc3WHBiUjJHQzhDZ2NJWEhuWkw5NGxjZ2gzdXRp";
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashPassword = passwordEncoder.encode(inputPassword);
		String base64 = Base64.getEncoder().encodeToString(hashPassword.getBytes(StandardCharsets.UTF_8));
		System.out.printf("加密后的密码%s",base64);
		System.out.println(passwordEncoder.matches(inputPassword,"JDJhJDEwJDEzN25HSWNSVzJZNnk3RjNwWXVFQXVSTTJhdDJBeGI5YWV5MGREbWJIUWNtSEZmcWpoMklh"));
	}
}
