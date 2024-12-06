package org.jiumao.moduleweb;

import lombok.Value;
import org.jiumao.moduleweb.storeorder.domain.vo.embed.CusMoney;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link org.jiumao.moduleweb.storeorder.domain.entities.Order}
 */
@Value
public class OrderRequest implements Serializable {
	Long teaMakerId;
	List<Long> itemIds;
	Double amountDisCount;
	String currency;
}
