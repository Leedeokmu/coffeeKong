package com.coffeekong.repository;

import com.coffeekong.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ManagerRepository extends JpaRepository<Manager, String> {
    Manager findByEmailAndPwd(String email, String pwd);
}
