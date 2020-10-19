package br.com.codeburger.codeburger.service;

import br.com.codeburger.codeburger.model.Ingredient;
import br.com.codeburger.codeburger.model.Order;
import br.com.codeburger.codeburger.model.OrderItem;
import br.com.codeburger.codeburger.repository.OrderItemRepository;
import br.com.codeburger.codeburger.repository.OrderRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;

    @Override
    public List<OrderItem> findAll() {
        return (List<OrderItem>) this.orderItemRepository.findAll();
    }

    @Override
    public OrderItem findById(Long id) throws NotFoundException {
        return this.orderItemRepository.findById(id).orElseThrow(() -> new NotFoundException("Resource Not Found"));
    }

    @Override
    public OrderItem create(OrderItem orderItem) {
        return this.orderItemRepository.save(orderItem);
    }

    @Override
    public void update(OrderItem orderItem) {
        this.orderItemRepository.save(orderItem);
    }

    @Override
    public void delete(Long id) {
        this.orderItemRepository.deleteById(id);
    }

    private void updateOrder(Long orderId){
        Optional<Order> older = this.orderRepository.findById(orderId);
        this.orderRepository.save(older.get());
    }
}