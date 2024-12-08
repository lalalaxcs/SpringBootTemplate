package org.jiumao.moduleweb.storeorder.domain.vo.embed;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jiumao.moduleweb.storeorder.domain.vo.converter.MoneyConverter;

import java.io.Serializable;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/11/23 15:57]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Amount implements Serializable {
	@Column(name = "amount_discount")
	private Double disCount;

	@Column(name = "amount_total")
	@Convert(converter = MoneyConverter.class)
	private CusMoney totalAmount;
	@Column(name = "amount_pay")
	@Convert(converter = MoneyConverter.class)
	private CusMoney payAmount;
}
