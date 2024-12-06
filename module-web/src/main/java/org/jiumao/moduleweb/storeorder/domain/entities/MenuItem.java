package org.jiumao.moduleweb.storeorder.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.jiumao.moduleweb.common.Annotaions.CurrencyField;
import org.jiumao.moduleweb.storeorder.domain.vo.converter.MoneyConverter;
import org.jiumao.moduleweb.storeorder.domain.vo.embed.CusMoney;
import org.jiumao.moduleweb.storeorder.domain.vo.enums.TeaSize;

import java.util.Date;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/11/14 22:06]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "t_menu")
@CurrencyField
public class MenuItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Enumerated(EnumType.STRING)
	private TeaSize size;
	@Convert(converter = MoneyConverter.class)
	private CusMoney price;
	@CreationTimestamp
	private Date createDate;
	@UpdateTimestamp
	private Date updateDate;
}
