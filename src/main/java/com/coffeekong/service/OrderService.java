package com.coffeekong.service;

import com.coffeekong.domain.CartVO;
import com.coffeekong.domain.SearchCriteria;
import com.coffeekong.model.Order;
import com.coffeekong.model.OrderProduct;
import com.coffeekong.repository.OrderProductRepository;
import com.coffeekong.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
@Slf4j
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderProductRepository orderProductRepository;

    @Transactional
    public void insOrder(Order vo, List<CartVO> list) {
        Order order = orderRepository.save(vo);

        for (CartVO cvo : list) {
            OrderProduct op = new OrderProduct();
            op.setOrderId(order.getId());
            op.setProductId(cvo.getProductId());
            op.setQty(cvo.getQty());
            op.setSz(cvo.getSz());
            op.setType(cvo.getType());
            op.setPrice(cvo.getSubPrice());

            orderProductRepository.save(op);
        }
    }

    public Page<Order> listByEmail(SearchCriteria cri, Pageable pageable, String email) {
        return orderRepository.findAllBySearchTypeAndKeywordAndEmail(cri.getSearchType(), cri.getKeyword(), email, pageable);
    }

    public Page<Order> list(SearchCriteria cri, Pageable pageable) {
        return orderRepository.findAllBySearchTypeAndKeyword(cri.getSearchType(), cri.getKeyword(), pageable);
    }

    public Order getByOid(int Oid) {
        return orderRepository.getOne(Oid);
    }

    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    public void delete(Integer oid) {
        orderRepository.delete(oid);
        orderProductRepository.deleteByOrderId(oid);
    }

    public void updateState(int oid, String state) {
        Order order = orderRepository.getOne(oid);
        order.setState(state);
        orderRepository.save(order);
    }

}
