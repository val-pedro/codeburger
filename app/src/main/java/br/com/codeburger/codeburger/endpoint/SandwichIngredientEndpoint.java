package br.com.codeburger.codeburger.endpoint;

import br.com.codeburger.codeburger.model.Ingredient;
import br.com.codeburger.codeburger.model.SandwichIngredient;
import br.com.codeburger.codeburger.service.IngredientService;
import br.com.codeburger.codeburger.service.SandwichIngredientService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1")
public class SandwichIngredientEndpoint {

    private final SandwichIngredientService sandwichIngredientService;

    @GetMapping(path = "protected/sandwich-ingredients")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(this.sandwichIngredientService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "protected/sandwich-ingredients/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(this.sandwichIngredientService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "protected/sandwich-ingredients")
    public ResponseEntity<?> create(@RequestBody SandwichIngredient sandwichIngredient){
        return new ResponseEntity<>(this.sandwichIngredientService.create(sandwichIngredient), HttpStatus.CREATED);
    }

    @PutMapping(path = "protected/sandwich-ingredients")
    public ResponseEntity<?> update(@RequestBody SandwichIngredient sandwichIngredient){
        this.sandwichIngredientService.update(sandwichIngredient);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "protected/sandwich-ingredients/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        this.sandwichIngredientService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
