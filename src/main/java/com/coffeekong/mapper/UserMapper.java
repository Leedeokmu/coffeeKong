package com.coffeekong.mapper;

import com.coffeekong.annotation.mapper.CoffeekongMapper;
import com.coffeekong.domain.SearchCriteria;
import com.coffeekong.domain.UserVO;
import com.coffeekong.dto.LoginDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CoffeekongMapper
public interface UserMapper{
	 UserVO login(LoginDTO dto);

	 String checkEmail(@Param("email")String email);

	 UserVO getUserWithSessionKey(@Param("key")String key);

	 void rmbLogin(@Param("email")String email,@Param("sess_id") String sess_id, @Param("limit")Date limit);

	 String checkId(@Param("email")String email);

	 void register(@Param("uvo")UserVO uvo);

	 void update(@Param("uvo")UserVO uvo);

	 String checkUserPw(@Param("uvo")UserVO uvo);

	 void delete(@Param("email")String email);

	 List<UserVO> list(@Param("cri") SearchCriteria cri);

	 int listCount(@Param("cri") SearchCriteria cri);

	 UserVO detail(@Param("email") String email);
}
