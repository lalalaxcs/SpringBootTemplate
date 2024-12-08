package org.jiumao.moduleweb.system.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.jiumao.moduleweb.storeorder.domain.entities.BaseEntity;
import org.jiumao.moduleweb.system.domain.vo.coverter.SysUserTypeConverter;
import org.jiumao.moduleweb.system.domain.vo.enums.SysUserType;
import org.springframework.stereotype.Service;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/8 20:36]
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SysUser extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String phone;

	private String salt;

	private String password;

	@Convert(converter = SysUserTypeConverter.class)
	private SysUserType sysUserType;

	private int enable;
}
