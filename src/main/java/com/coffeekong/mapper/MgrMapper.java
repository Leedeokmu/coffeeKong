package com.coffeekong.mapper;

import com.coffeekong.annotation.mapper.CoffeekongMapper;
import com.coffeekong.domain.MgrVO;
import com.coffeekong.dto.LoginDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CoffeekongMapper
public interface MgrMapper {

	MgrVO login(@Param("dto") LoginDTO dto);
	void rmbLogin(@Param("email") String email, @Param("sessionId") String sessionId, @Param("limit") Date limit);
	
}
