package com.coffeekong.repository;

import com.coffeekong.model.User;
import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {
    User findByEmailAndAndPwd(String email, String pwd);
    User findBySessIdAndAndSessLimitAfter(String sessId, DateTime SessLimit);
    User

    UPDATE
            tbl_user
    SET
    sess_id = #{sess_id}, sess_limit = #{limit}
    WHERE
    u_email = #{email}


}
