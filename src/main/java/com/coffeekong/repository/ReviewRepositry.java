package com.coffeekong.repository;

import com.coffeekong.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ReviewRepositry extends JpaRepository<Review, Integer> {

    Page<Review> findAllByProductId(Integer productId, Pageable pageable);

}
