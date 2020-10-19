package br.com.codeburger.codeburger.service;

import br.com.codeburger.codeburger.model.SandwichIngredient;
import br.com.codeburger.codeburger.repository.SandwichIngredientRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SandwichIngredientServiceImpl implements  SandwichIngredientService{
    private final SandwichIngredientRepository sandwichIngredientRepository;

    @Override
    public List<SandwichIngredient> findAll() {
        return (List<SandwichIngredient>) this.sandwichIngredientRepository.findAll();
    }

    @Override
    public SandwichIngredient findById(Long id) throws NotFoundException {
        return this.sandwichIngredientRepository.findById(id).orElseThrow(() -> new NotFoundException("Resource Not Found"));
    }

    @Override
    public SandwichIngredient create(SandwichIngredient sandwichIngredient) {
        return this.sandwichIngredientRepository.save(sandwichIngredient);
    }

    @Override
    public void update(SandwichIngredient sandwichIngredient) {
        this.sandwichIngredientRepository.save(sandwichIngredient);
    }

    @Override
    public void delete(Long id) {
        this.sandwichIngredientRepository.deleteById(id);
    }
}
