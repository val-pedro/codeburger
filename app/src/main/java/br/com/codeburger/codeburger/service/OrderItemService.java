package br.com.codeburger.codeburger.service;

import br.com.codeburger.codeburger.model.OrderItem;
import javassist.NotFoundException;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> findAll();

    OrderItem findById(Long id) throws NotFoundException;

    OrderItem create(OrderItem orderItem);

    void update(OrderItem orderItem);

    void delete(Long id);
}
