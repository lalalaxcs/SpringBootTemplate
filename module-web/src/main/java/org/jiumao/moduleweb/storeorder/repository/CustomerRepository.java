package org.jiumao.moduleweb.storeorder.repository;

import org.jiumao.moduleweb.storeorder.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/8 20:31]
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
