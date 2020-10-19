package br.com.codeburger.codeburger.repository;

import br.com.codeburger.codeburger.model.Ingredient;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends PagingAndSortingRepository<Ingredient, Long> {

}
