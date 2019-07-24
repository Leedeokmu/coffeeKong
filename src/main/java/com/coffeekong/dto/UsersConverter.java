package com.coffeekong.dto;

import com.coffeekong.model.Users;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UsersConverter implements Converter<UsersDto, Users> {
    @Override
    public Users convert(UsersDto usersDto) {
        Users user = new Users();
        user.setEmail(usersDto.getEmail());
        user.setFname(usersDto.getFname());
        user.setLname(usersDto.getLname());
        user.setPwd(usersDto.getPwd());

        return user;
    }
}
