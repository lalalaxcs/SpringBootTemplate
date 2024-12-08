package org.jiumao.moduleweb.system.domain.vo.enums;

import org.jiumao.moduleweb.common.Exception.JMBizException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/8 20:47]
 */
public enum SysUserType {
	CUSTOMER("顾客", 1),
	STAFF("员工", 2),
	ADMIN("管理员", 3),
	DEVELOPER("开发人员", 4),
	ANONYMOUS("暂无类型", 5);

	private final String displayName;
	private final int code;

	private static final Map<Integer, SysUserType> CODE_TO_USER_TYPE_MAP = new HashMap<>();

	static {
		// 将枚举常量及其 code 映射到 HashMap 中
		for (SysUserType userType : values()) {
			CODE_TO_USER_TYPE_MAP.put(userType.getCode(), userType);
		}
	}


	SysUserType(String displayName, int code) {
		this.displayName = displayName;
		this.code = code;
	}

	public String getDisplayName() {
		return displayName;
	}

	public int getCode() {
		return code;
	}

	public static SysUserType fromCode(Integer code) {
		Optional<SysUserType> sysUserType = Optional.ofNullable(CODE_TO_USER_TYPE_MAP.get(code));
		return sysUserType.orElseThrow(() -> new JMBizException("无效的用户类型编码" + code));
	}
}
