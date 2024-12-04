package org.jiumao.moduleweb.storeorder.domain.vo.enums;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/11/23 15:54]
 */
public enum OrderStatus {
	CREATED("已创建"),
	PAID("已支付"),
	MAKING("制作中"),
	FINISHED("已完成"),
	CANCELED("已取消");

	private final String displayName;

	OrderStatus(String displayName) {
		this.displayName = displayName;
	}

	private String getDisplayName() {
		return displayName;
	}
}
