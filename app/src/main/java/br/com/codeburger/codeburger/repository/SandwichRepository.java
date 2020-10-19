package br.com.codeburger.codeburger.repository;

import br.com.codeburger.codeburger.model.Sandwich;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SandwichRepository extends PagingAndSortingRepository<Sandwich, Long> {

}