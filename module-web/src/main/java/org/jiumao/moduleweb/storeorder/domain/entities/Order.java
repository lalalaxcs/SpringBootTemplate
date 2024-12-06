package org.jiumao.moduleweb.storeorder.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.jiumao.moduleweb.storeorder.domain.vo.embed.Amount;
import org.jiumao.moduleweb.storeorder.domain.vo.enums.OrderStatus;

import java.util.Date;
import java.util.List;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/11/23 15:51]
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_order")
@Builder
@ToString

public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maker_id")
	private TeaMaker teaMaker;

	@ManyToMany
	@JoinTable(name = "t_order_item",
			joinColumns = @JoinColumn(name = "item_id"),
			inverseJoinColumns = @JoinColumn(name = "order_id"))
	private List<MenuItem> items;
	@Enumerated
	private Amount amount;

	@Column(name = "currency", length = 20)
	private String currency;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@CreationTimestamp
	private Date createTime;

	@UpdateTimestamp
	private Date updateTime;
}
