package com.coffeekong.repository;

import com.coffeekong.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategory(String category);

    @Modifying
    @Query(
            value = "SELECT p FROM Product p WHERE " +
                    "CASE WHEN :searchType = 'prodNm' THEN name WHEN :searchType = 'category' THEN category ELSE name END " +
                    "LIKE CONCAT('%', :keyword, '%') ORDER BY rdate",
            countQuery = "SELECT count(p) FROM Product p WHERE " +
                    "CASE WHEN :searchType = 'prodNm' THEN name WHEN :searchType = 'category' THEN category ELSE name END " +
                    "LIKE CONCAT('%', :keyword, '%') ORDER BY rdate"
    )
    Page<Product> findAllBySearchTypeAndKeyword(String searchType, String keyword, Pageable pageable);


}
