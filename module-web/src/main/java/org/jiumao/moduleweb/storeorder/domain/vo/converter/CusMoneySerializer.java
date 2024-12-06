package org.jiumao.moduleweb.storeorder.domain.vo.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.jiumao.moduleweb.storeorder.domain.vo.embed.CusMoney;

import java.io.IOException;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/5 21:51]
 */
public class CusMoneySerializer extends JsonSerializer<CusMoney> {
	@Override
	public void serialize(CusMoney cusMoney, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("amount", cusMoney.getAmount().toString());
		jsonGenerator.writeStringField("currencyCode", cusMoney.getCurrencyCode());
		jsonGenerator.writeEndObject();
	}
}
