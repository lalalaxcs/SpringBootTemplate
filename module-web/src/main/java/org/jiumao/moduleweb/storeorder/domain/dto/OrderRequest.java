package org.jiumao.moduleweb.storeorder.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link org.jiumao.moduleweb.storeorder.domain.entities.Order}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest implements Serializable {
	Long teaMakerId;
	List<Long> itemIds;
	Double amountDisCount;
	String currency;
}
