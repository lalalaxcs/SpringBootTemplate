package org.jiumao.moduleweb.storeorder.domain.vo.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.jiumao.moduleweb.common.Annotaions.CurrencyField;
import org.jiumao.moduleweb.storeorder.domain.vo.embed.CusMoney;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Set;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/4 22:11]
 */
public class CurrencyJsonSerializer extends JsonSerializer<Object> {
	@Override
	public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
		processObject(o, jsonGenerator, null, false);
	}

	private void processObject(Object obj, JsonGenerator gen, String parentCurrency, boolean isNested) throws IOException {
		if (obj == null) return;

		// 获取对象的 class
		Class<?> clazz = obj.getClass();

		// 如果类有 CurrencyField 注解，则获取该货币类型
		String targetCurrency = getCurrencyFromAnnotation(obj, parentCurrency);
		if (!isNested) {
			gen.writeStartObject();
		}

		// 遍历字段
		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			// 如果字段类型是 Money 类型，转换货币
			if (CusMoney.class.isAssignableFrom(field.getType())) {
				try {
					CusMoney money = (CusMoney) field.get(obj);
					if (money != null) {
						CusMoney convertedMoney = convertMoneyToCurrency(money, targetCurrency);
						gen.writeObjectField(field.getName(), convertedMoney);
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			} else if (field.getType().isAnnotationPresent(CurrencyField.class)) {
				// 如果是嵌套对象，递归处理
				try {
					Object nestedObject = field.get(obj);
					if (nestedObject != null) {
//						gen.writeObjectFieldStart(field.getName());
//						gen.writeObjectField(field.getName(), nestedObject);
						processObject(nestedObject, gen, targetCurrency, true);
//						gen.writeEndObject();
					} else {
						gen.writeNullField(field.getName());
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			} else if (field.getType().isArray() || field.getType().equals(List.class) || field.getType().equals(Set.class)) {
				// 如果是数组或集合，递归处理每个元素
				try {
					Object fieldValue = field.get(obj);
					if (fieldValue != null) {
//						gen.writeFieldName(field.getName()); // 写入字段名
//						gen.writeObjectField(field.getName(),fieldValue);
//						gen.writeObjectFieldStart(field.getName()); // 写字段名
						gen.writeArrayFieldStart(field.getName());
						gen.writeStartArray(); // 启动数组写入
						if (fieldValue instanceof Object[]) {
							// 处理数组
							for (Object item : (Object[]) fieldValue) {
								if (item != null) {
									processObject(item, gen, targetCurrency, false); // 递归处理数组元素
								}
							}
						} else if (fieldValue instanceof List<?>) {
							// 处理 List
							for (Object item : (List<?>) fieldValue) {
								if (item != null) {
									processObject(item, gen, targetCurrency, false); // 递归处理 List 元素
								}
							}
						} else if (fieldValue instanceof Set<?>) {
							// 处理 Set
							for (Object item : (Set<?>) fieldValue) {
								if (item != null) {
									processObject(item, gen, targetCurrency, false); // 递归处理 Set 元素
								}
							}
						}
						gen.writeEndArray(); // 结束数组的写入
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			} else {
				// 处理普通类型字段
				try {
					Object fieldValue = field.get(obj);
					if (fieldValue != null) {
						// 写入普通字段
						gen.writeObjectField(field.getName(), fieldValue);
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		if (!isNested) {
			gen.writeEndObject();
		}
	}

	private String getCurrencyFromAnnotation(Object obj, String parentCurrency) {
		try {
			// 查找 currency 字段
			//检查currency字段是否存在
//			boolean existCurrencyField = isExistCurrencyField(obj.getClass().getDeclaredFields());
//			if(!existCurrencyField){
//				return parentCurrency==null?"CNY":parentCurrency;
//			}
			Field currencyField = obj.getClass().getDeclaredField("currency");
			currencyField.setAccessible(true);
			Object currencyValue = currencyField.get(obj);
			// 如果 currency 字段存在且不为空
			return currencyValue.toString();
		} catch (NoSuchFieldException | IllegalAccessException e) {
			// 如果没有找到 currency 字段，或无法访问，返回默认货币 "CNY"
			return parentCurrency == null ? "CNY" : parentCurrency;
		}
	}

	private CusMoney convertMoneyToCurrency(CusMoney money, String targetCurrency) {
		return money.convertedTo(targetCurrency, BigDecimal.ONE, RoundingMode.HALF_UP);
	}
}
