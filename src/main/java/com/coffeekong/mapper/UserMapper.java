package com.coffeekong.mapper;

import com.coffeekong.annotation.mapper.CoffeekongMapper;
import com.coffeekong.domain.SearchCriteria;
import com.coffeekong.domain.UserVO;
import com.coffeekong.dto.LoginDTO;
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

	 String checkEmail(String email);

	 UserVO getUserWithSessionKey(String key);

	 void rmbLogin(String email, String sess_id, Date limit);

	 String checkId(String email);

	 void register(UserVO uvo);

	 void update(UserVO uvo);

	 String checkUserPw(UserVO uvo);

	 void delete(String email);

	 List<UserVO> list(SearchCriteria cri);

	 int listCount(SearchCriteria cri);

	 UserVO detail(String email);
}
