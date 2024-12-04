package org.jiumao.moduleweb.storeorder.domain.vo.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.money.Money;

import java.io.IOException;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/3 21:52]
 */
public class MoneySerializer extends JsonSerializer<Money> {
	@Override
	public void serialize(Money money, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
		String amount = money.getAmount().toString();  // 金额
		String currencyCode = money.getCurrencyUnit().getCode();  // 货币代码
		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("amount", amount);
		jsonGenerator.writeStringField("currencyCode", currencyCode);
		jsonGenerator.writeEndObject();
	}
}
