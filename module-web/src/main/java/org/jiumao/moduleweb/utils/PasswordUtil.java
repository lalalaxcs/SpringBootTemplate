package org.jiumao.moduleweb.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/8 21:26]
 */
@Component
public class PasswordUtil {
	public String enCodePassword(String plaintext) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String ciphertext = passwordEncoder.encode(plaintext);
		return Base64.getEncoder().encodeToString(ciphertext.getBytes(StandardCharsets.UTF_8));
	}

	public boolean isMatch(String plaintext, String ciphertext) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(plaintext, new String(Base64.getDecoder().decode(ciphertext)));
	}
}
