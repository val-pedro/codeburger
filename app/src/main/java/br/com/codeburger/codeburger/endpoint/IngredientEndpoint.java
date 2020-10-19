package br.com.codeburger.codeburger.endpoint;

import br.com.codeburger.codeburger.model.Ingredient;
import br.com.codeburger.codeburger.service.IngredientService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1")
public class IngredientEndpoint {

    private final IngredientService ingredientService;

    @GetMapping(path = "protected/ingredients")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(this.ingredientService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "protected/ingredients/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(this.ingredientService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "protected/ingredients")
    public ResponseEntity<?> create(@RequestBody Ingredient ingredient){
        return new ResponseEntity<>(this.ingredientService.create(ingredient), HttpStatus.CREATED);
    }

    @PutMapping(path = "protected/ingredients")
    public ResponseEntity<?> update(@RequestBody Ingredient ingredient){
        this.ingredientService.update(ingredient);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "protected/ingredients/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        this.ingredientService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}