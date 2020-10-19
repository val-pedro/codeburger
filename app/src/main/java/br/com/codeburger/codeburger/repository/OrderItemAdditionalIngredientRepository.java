package br.com.codeburger.codeburger.repository;

import br.com.codeburger.codeburger.model.OrderItemAdditionalIngredient;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemAdditionalIngredientRepository extends PagingAndSortingRepository<OrderItemAdditionalIngredient, Long> {
}
