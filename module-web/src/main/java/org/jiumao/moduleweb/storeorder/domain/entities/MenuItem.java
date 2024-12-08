package org.jiumao.moduleweb.storeorder.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.jiumao.moduleweb.storeorder.domain.vo.converter.MoneyConverter;
import org.jiumao.moduleweb.storeorder.domain.vo.embed.CusMoney;
import org.jiumao.moduleweb.storeorder.domain.vo.enums.TeaSize;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/11/14 22:06]
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_menu")
public class MenuItem extends BaseEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Enumerated(EnumType.STRING)
	private TeaSize size;
	@Convert(converter = MoneyConverter.class)
	private CusMoney price;

}
