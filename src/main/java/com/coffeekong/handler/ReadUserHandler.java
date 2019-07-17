package com.coffeekong.handler;

import com.coffeekong.dto.Paging;
import com.coffeekong.model.User;
import com.coffeekong.service.ReadUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Component
public class ReadUserHandler {
    private final ReadUserService readUserService;

    public Mono<ServerResponse> listUser(ServerRequest request){
        pageable = PageRequest.of(pageable.getPageNumber() == 0 ? pageable.getPageNumber() : pageable.getPageNumber() - 1, 5, new Sort(Sort.Direction.ASC, "id"));
        Page<User> users = readUserService.getUserList(pageable);
        Paging paging = new Paging();
        paging.setPageNo(pageable.getPageNumber() + 1);
        paging.setPageSize(pageable.getPageSize());
        paging.setTotalCount((int)users.getTotalElements());

        model.addAttribute("content", "user-list");
        model.addAttribute("paging", paging);
        model.addAttribute("users", users);
    }
}
