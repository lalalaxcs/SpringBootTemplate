package org.jiumao.moduleweb.storeorder.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/8 16:07]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_cus_address")
@EqualsAndHashCode(callSuper = false)
@Entity
public class Address extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String country;

	private String zipCode;

	private String city;

	private String concreteDec;

	private int defaultAddress;

}
