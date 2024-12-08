package org.jiumao.moduleweb.storeorder.domain.vo.embed;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/5 21:33]
 */
@Setter
@Getter
public class CusMoney implements Serializable {
	private BigDecimal amount;  // 数值
	private String currencyCode = "CNY";  // 货币类型

	// 构造函数
	public CusMoney(BigDecimal amount, String currencyCode) {
		this.amount = amount;
		this.currencyCode = currencyCode;
	}

	public CusMoney(BigDecimal amount) {
		this.amount = amount;
	}

	public static CusMoney ofMinor(String currencyCode, BigDecimal minorUnits) {
		return new CusMoney(minorUnits.divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP), currencyCode);
	}

	public static CusMoney of(BigDecimal amount){
		return new CusMoney(amount);
	}

	public static CusMoney of(BigDecimal amount,String currencyCode){
		return new CusMoney(amount,currencyCode);
	}

	// 判断是否为负数
	public boolean isNegative() {
		return amount.signum() == -1;
	}

	// 判断是否为零
	public boolean isZero() {
		return amount.signum() == 0;
	}

	// 判断是否为正数
	public boolean isPositive() {
		return amount.signum() == 1;
	}

	// 转换为字符串表示
	@Override
	public String toString() {
		return amount.toString() + " " + currencyCode;
	}

	public CusMoney convertedTo(String targetCurrencyUnit, BigDecimal exchangeRate, RoundingMode roundingMode) {
		// 假设这里通过外部传入的 exchangeRate（汇率）来进行转换
		if (this.currencyCode.equals(targetCurrencyUnit)) {
			// 如果目标货币与当前货币相同，直接返回原金额
			return this;
		}

		// 计算转换后的金额
		BigDecimal convertedAmount = this.amount.multiply(exchangeRate).setScale(2, roundingMode);

		return new CusMoney(convertedAmount, targetCurrencyUnit);
	}
}
