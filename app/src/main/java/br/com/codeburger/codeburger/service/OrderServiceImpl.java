package br.com.codeburger.codeburger.service;

import br.com.codeburger.codeburger.model.Order;
import br.com.codeburger.codeburger.model.OrderItem;
import br.com.codeburger.codeburger.repository.OrderItemRepository;
import br.com.codeburger.codeburger.repository.OrderRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public List<Order> findAll() {
        return (List<Order>) this.orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) throws NotFoundException {
        return this.orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Resource not found"));
    }

    @Override
    public Order create(Order order) {

        // Save Order
        Order orderInsert = this.orderRepository.save(order);

        this.orderItemSave(orderInsert);

        return orderInsert;
        // Calculate order price
    }

    @Override
    public void update(Order order) {
        this.orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        this.orderRepository.deleteById(id);
    }

    private void orderItemSave(Order order) {

        // Save the OrderItems
        Order orderCopy = new Order();
        orderCopy.setId(order.getId());
        orderCopy.setDate(order.getDate());
        orderCopy.setValue(order.getValue());

        for (OrderItem item : order.getOrderItems()) {
            item.setOrder(orderCopy);
            orderItemRepository.save(item);
        }
        order.setOrderItems(orderCopy.getOrderItems());
    }
}
