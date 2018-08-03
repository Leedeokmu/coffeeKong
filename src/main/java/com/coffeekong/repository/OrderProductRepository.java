package com.coffeekong.repository;

import com.coffeekong.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {

    void deleteByOrderId(Integer orderId);

}
