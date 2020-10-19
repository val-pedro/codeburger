package br.com.codeburger.codeburger.service;

import br.com.codeburger.codeburger.model.Ingredient;
import javassist.NotFoundException;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findAll();

    Ingredient findById(Long id) throws NotFoundException;

    Ingredient create(Ingredient ingredient);

    void update(Ingredient ingredient);

    void delete(Long id);
}
