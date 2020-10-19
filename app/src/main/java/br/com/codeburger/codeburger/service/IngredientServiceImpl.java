package br.com.codeburger.codeburger.service;

import br.com.codeburger.codeburger.model.Ingredient;
import br.com.codeburger.codeburger.repository.IngredientRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class IngredientServiceImpl implements IngredientService {
    
    private final IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> findAll() {
        return (List<Ingredient>) this.ingredientRepository.findAll();
    }

    @Override
    public Ingredient findById(Long id) throws NotFoundException {
        return this.ingredientRepository.findById(id).orElseThrow(() -> new NotFoundException("Resource Not Found"));
    }

    @Override
    public Ingredient create(Ingredient ingredient) {
        return this.ingredientRepository.save(ingredient);
    }

    @Override
    public void update(Ingredient ingredient) {
        this.ingredientRepository.save(ingredient);
    }

    @Override
    public void delete(Long id) {
        this.ingredientRepository.deleteById(id);
    }
}
