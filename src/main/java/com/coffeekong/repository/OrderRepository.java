package com.coffeekong.repository;

import com.coffeekong.model.Order;
import com.coffeekong.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Modifying
    @Query(
            value = "SELECT o FROM Order o " +
                    "LEFT JOIN o.opvo op " +
                    "ON o.id = op.id" +
                    "LEFT JOIN op.product p " +
                    "ON op.productId = p.id " +
                    "WHERE CASE WHEN :searchType = 'prodNm' THEN p.name ELSE p.name END " +
                    "LIKE CONCAT('%', :keyword, '%') " +
                    "AND o.email = :email ORDER BY o.id",
            countQuery = "SELECT count(o) FROM Order o " +
                    "LEFT JOIN o.opvo op " +
                    "ON o.id = op.id" +
                    "LEFT JOIN op.product p " +
                    "ON op.productId = p.id " +
                    "WHERE CASE WHEN :searchType = 'prodNm' THEN p.name ELSE p.name END " +
                    "LIKE CONCAT('%', :keyword, '%') " +
                    "AND o.email = :email "
    )
    Page<Order> findAllBySearchTypeAndKeywordAndEmail(String searchType, String keyword, String email, Pageable pageable);

    @Modifying
    @Query(
            value = "SELECT o FROM Order o " +
                    "LEFT JOIN o.opvo op " +
                    "ON o.id = op.id" +
                    "LEFT JOIN op.product p " +
                    "ON op.productId = p.id " +
                    "WHERE CASE WHEN :searchType = 'prodNm' THEN p.name WHEN :searchType = 'email' THEN o.email ELSE p.name END " +
                    "LIKE CONCAT('%', :keyword, '%') ORDER BY o.id",
            countQuery = "SELECT count(o) FROM Order o " +
                    "LEFT JOIN o.opvo op " +
                    "ON o.id = op.id" +
                    "LEFT JOIN op.product p " +
                    "ON op.productId = p.id " +
                    "WHERE CASE WHEN :searchType = 'prodNm' THEN p.name WHEN :searchType = 'email' THEN o.email ELSE p.name END " +
                    "LIKE CONCAT('%', :keyword, '%')"
    )
    Page<Order> findAllBySearchTypeAndKeyword(String searchType, String keyword, Pageable pageable);




}
