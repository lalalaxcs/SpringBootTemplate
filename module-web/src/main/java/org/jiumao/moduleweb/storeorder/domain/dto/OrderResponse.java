package org.jiumao.moduleweb.storeorder.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;
import org.jiumao.moduleweb.storeorder.domain.entities.MenuItem;
import org.jiumao.moduleweb.storeorder.domain.vo.converter.CurrencyJsonSerializer;
import org.jiumao.moduleweb.storeorder.domain.vo.embed.Amount;
import org.jiumao.moduleweb.storeorder.domain.vo.enums.OrderStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/3 22:46]
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
//@JsonSerialize(using = CurrencyJsonSerializer.class)
public class OrderResponse implements Serializable {
	private Long id;

	private String teaMakerName;

	private List<MenuItem> items;

	private Amount amount;

	private OrderStatus status;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime createTime;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime updateTime;

	private String currency;

}
