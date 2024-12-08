package org.jiumao.moduleweb.storeorder.repository;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.jiumao.moduleweb.storeorder.domain.entities.Order;
import org.jiumao.moduleweb.storeorder.domain.entities.TeaMaker;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : [xvChuShun]
 * @createTime : [2024/12/6 14:24]
 */
public interface TeaMakerRepository extends JpaRepository<TeaMaker, Long> {
}
