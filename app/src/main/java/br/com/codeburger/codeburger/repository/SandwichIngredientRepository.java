package br.com.codeburger.codeburger.repository;

import br.com.codeburger.codeburger.model.SandwichIngredient;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SandwichIngredientRepository extends PagingAndSortingRepository<SandwichIngredient, Long> {
}