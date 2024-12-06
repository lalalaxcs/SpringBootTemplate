package org.jiumao.moduleweb.storeorder.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.jiumao.moduleweb.storeorder.domain.entities.MenuItem;
import org.jiumao.moduleweb.storeorder.domain.vo.converter.CurrencyJsonSerializer;
import org.jiumao.moduleweb.storeorder.domain.vo.embed.Amount;
import org.jiumao.moduleweb.storeorder.domain.vo.enums.OrderStatus;

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
public class OrderResponse {
	private Long id;

	private String teaMakerName;

	private List<MenuItem> items;

	private Amount amount;

	private OrderStatus status;

	private Date createTime;

	private Date updateTime;

	private String currency;

}
