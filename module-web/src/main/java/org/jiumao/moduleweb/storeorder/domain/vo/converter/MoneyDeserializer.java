package org.jiumao.moduleweb.storeorder.domain.vo.converter;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.money.Money;

import java.io.IOException;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/3 21:54]
 */
public class MoneyDeserializer extends JsonDeserializer<Money> {
	@Override
	public Money deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
		String text = jsonParser.getText().trim();
		return Money.parse("CNY " + text);
	}
}
