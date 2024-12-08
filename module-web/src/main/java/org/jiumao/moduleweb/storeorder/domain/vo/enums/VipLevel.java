package org.jiumao.moduleweb.storeorder.domain.vo.enums;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/8 15:18]
 */
public enum VipLevel {
	BRONZE("铜", 1),
	SILVER("银", 2),
	GOLD("金", 3),
	PLATINUM("铂金", 4),
	DIAMOND("钻石", 5);

	private final String displayName;  // 显示名称
	private final int level;           // 等级，数值越大等级越高

	VipLevel(String displayName, int level) {
		this.displayName = displayName;
		this.level = level;
	}

	public String getDisplayName() {
		return displayName;
	}

	public int getLevel() {
		return level;
	}

	// 根据等级数值获取对应的枚举值
	public static VipLevel fromLevel(int level) {
		for (VipLevel vipLevel : values()) {
			if (vipLevel.level == level) {
				return vipLevel;
			}
		}
		throw new IllegalArgumentException("无效的VIP等级：" + level);
	}

	// 根据显示名称获取对应的枚举值
	public static VipLevel fromDisplayName(String displayName) {
		for (VipLevel vipLevel : values()) {
			if (vipLevel.displayName.equalsIgnoreCase(displayName)) {
				return vipLevel;
			}
		}
		throw new IllegalArgumentException("无效的VIP等级名称：" + displayName);
	}
}
