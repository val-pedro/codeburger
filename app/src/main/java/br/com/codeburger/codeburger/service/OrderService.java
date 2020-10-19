package br.com.codeburger.codeburger.service;

import br.com.codeburger.codeburger.dto.OrderDTO;
import br.com.codeburger.codeburger.model.Order;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {
    public List<Order> findAll();

    public Order findById(Long id) throws NotFoundException;

    public Order create(Order order);

    public void update(Order order);

    public void delete(Long id);
}
