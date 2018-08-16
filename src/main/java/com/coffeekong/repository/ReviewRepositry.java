package com.coffeekong.repository;

import com.coffeekong.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepositry extends JpaRepository<Review, Integer> {

}
