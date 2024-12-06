package org.jiumao.moduleweb.common.Annotaions;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/4 22:03]
 */
@Target(ElementType.TYPE)  // 可以用于字段
@Retention(RetentionPolicy.RUNTIME)  // 运行时有效
public @interface CurrencyField {
	// 可设置货币的默认类型，如果有必要
	String value() default "USD";
}
