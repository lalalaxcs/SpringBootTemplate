package org.jiumao.moduleweb.system.domain.vo.coverter;

import jakarta.persistence.AttributeConverter;
import org.jiumao.moduleweb.system.domain.vo.enums.SysUserType;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/8 20:55]
 */
public class SysUserTypeConverter implements AttributeConverter<SysUserType, Integer> {

	@Override
	public Integer convertToDatabaseColumn(SysUserType userType) {
		return userType != null ? userType.getCode() : SysUserType.ANONYMOUS.getCode();
	}

	@Override
	public SysUserType convertToEntityAttribute(Integer dbData) {
		return SysUserType.fromCode(dbData);
	}
}
