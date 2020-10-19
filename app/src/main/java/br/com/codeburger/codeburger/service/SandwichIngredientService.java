package br.com.codeburger.codeburger.service;

import br.com.codeburger.codeburger.model.Ingredient;
import br.com.codeburger.codeburger.model.SandwichIngredient;
import javassist.NotFoundException;

import java.util.List;

public interface SandwichIngredientService {
    List<SandwichIngredient> findAll();

    SandwichIngredient findById(Long id) throws NotFoundException;

    SandwichIngredient create(SandwichIngredient sandwichIngredient);

    void update(SandwichIngredient sandwichIngredient);

    void delete(Long id);
}
