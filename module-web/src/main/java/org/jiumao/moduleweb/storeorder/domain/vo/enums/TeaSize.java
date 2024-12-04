package org.jiumao.moduleweb.storeorder.domain.vo.enums;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/11/23 14:28]
 */
public enum TeaSize {
	SMALL("小杯"),
	MEDIUM("中杯"),
	LARGE("大杯");

	private final String displayName;

	TeaSize(String displayName) {
		this.displayName = displayName;
	}

	private String getDisplayName() {
		return displayName;
	}
}
