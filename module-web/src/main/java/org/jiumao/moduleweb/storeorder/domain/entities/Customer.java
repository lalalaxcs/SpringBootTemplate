package org.jiumao.moduleweb.storeorder.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/8 14:59]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_customer")
@EqualsAndHashCode(callSuper = false)
@Entity
public class Customer extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	//vip状态
	//0 不是vip
	//1 生效
	//2 过期
	private int isVipActive;

	@OneToMany
	@JoinColumn(name = "address_id")
	private List<Address> address;

}
