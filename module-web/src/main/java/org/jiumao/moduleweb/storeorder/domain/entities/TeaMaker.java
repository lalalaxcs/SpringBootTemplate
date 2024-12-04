package org.jiumao.moduleweb.storeorder.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/11/23 15:48]
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_tea_maker")
public class TeaMaker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	@OneToMany(mappedBy = "teaMaker")
	@OrderBy("id desc ")
	private List<Order> orders = new ArrayList<>();

	@CreationTimestamp
	private Date createTime;
	@UpdateTimestamp
	private Date updateTime;
}
