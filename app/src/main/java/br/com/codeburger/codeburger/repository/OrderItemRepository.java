package br.com.codeburger.codeburger.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import br.com.codeburger.codeburger.model.OrderItem;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends PagingAndSortingRepository<OrderItem, Long> {
}
