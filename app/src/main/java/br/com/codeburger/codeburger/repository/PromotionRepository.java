package br.com.codeburger.codeburger.repository;

import br.com.codeburger.codeburger.model.Promotion;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PromotionRepository extends PagingAndSortingRepository<Promotion, Long> {
}
