package org.jiumao.moduleweb.storeorder.domain.vo.converter;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/2 22:15]
 */

import cn.hutool.core.util.ObjectUtil;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Converter(autoApply = true)
public class MoneyConverter implements AttributeConverter<Money, BigDecimal> {

	@Override
	public BigDecimal convertToDatabaseColumn(Money money) {
		if (ObjectUtil.isEmpty(money)) {
			return null;
		}
		// 将Money转为最小单位（如分），放大100倍
		return money.getAmount().multiply(BigDecimal.valueOf(100));
	}

	@Override
	public Money convertToEntityAttribute(BigDecimal bigDecimal) {
		if (bigDecimal == null) {
			return null;
		}
		// 读取时缩小100倍恢复为元
		CurrencyUnit currencyUnit = CurrencyUnit.of("CNY");
		long minorUnits = bigDecimal.setScale(4, RoundingMode.HALF_UP).longValue();
		return Money.ofMinor(currencyUnit, minorUnits);
	}
}
