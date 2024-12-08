package org.jiumao.moduleweb.storeorder.repository;

import org.jiumao.moduleweb.storeorder.domain.entities.MenuItem;
import org.jiumao.moduleweb.storeorder.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/6 14:25]
 */
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
