package org.jiumao.moduleweb.common.dto;

import lombok.*;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/6 13:33]
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ApiResponse<T> {
	private int opStatus;
	private T data;
	private String msg;

	public static <T> ApiResponse<T> ofSuccess(T data, String msg) {
		return new ApiResponse<T>(200, data, msg);
	}

	public static <T> ApiResponse<T> ofError(int opStatus, T data, String msg) {
		return new ApiResponse<T>(opStatus, data, msg);
	}

	public static <T> ApiResponse<T> ofFailed(T data, String msg) {
		return new ApiResponse<T>(405, data, msg);
	}
}
