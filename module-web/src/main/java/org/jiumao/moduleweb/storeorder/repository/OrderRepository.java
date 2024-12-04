package org.jiumao.moduleweb.storeorder.repository;

import org.jiumao.moduleweb.storeorder.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/2 22:39]
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
