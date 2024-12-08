package org.jiumao.moduleweb.storeorder.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
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
@EqualsAndHashCode(callSuper = false)
public class TeaMaker extends BaseEntity implements   Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	@OneToMany(mappedBy = "teaMaker")
	@OrderBy("id desc ")
	private List<Order> orders = new ArrayList<>();

}
