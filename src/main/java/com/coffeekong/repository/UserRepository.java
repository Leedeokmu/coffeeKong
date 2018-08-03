package com.coffeekong.repository;

import com.coffeekong.model.User;
import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, String> {

    User findByEmailAndAndPwd(String email, String pwd);
    User findBySessIdAndAndSessLimitAfter(String sessId, DateTime SessLimit);

    @Modifying
    @Query(
            value = "SELECT u FROM User u WHERE " +
                    "CASE WHEN :searchType = 'email' THEN email ELSE email END " +
                    "LIKE CONCAT('%', :keyword, '%') ORDER BY email",
            countQuery = "SELECT count(u) FROM User u WHERE " +
                    "CASE WHEN :searchType = 'email' THEN email ELSE email END " +
                    "LIKE CONCAT('%', :keyword, '%')"
    )
    Page<User> findAllBySearchTypeAndKeyword(String searchType, String keyword, Pageable pageable);



}
