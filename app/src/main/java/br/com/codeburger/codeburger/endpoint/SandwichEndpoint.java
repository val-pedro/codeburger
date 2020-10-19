package br.com.codeburger.codeburger.endpoint;

import br.com.codeburger.codeburger.model.Sandwich;
import br.com.codeburger.codeburger.service.SandwichService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class SandwichEndpoint {

    private SandwichService sandwichService;

    @Autowired
    public SandwichEndpoint(SandwichService sandwichService) {
        this.sandwichService = sandwichService;
    }

    @GetMapping(path = "protected/sandwiches")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(this.sandwichService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "protected/sandwiches/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(this.sandwichService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "protected/sandwiches")
    public ResponseEntity<?> create(@RequestBody Sandwich sandwich){
        return new ResponseEntity<>(this.sandwichService.create(sandwich), HttpStatus.CREATED);
    }

    @PutMapping(path = "protected/sandwiches")
    public ResponseEntity<?> update(@RequestBody Sandwich sandwich){
        return new ResponseEntity<>(this.sandwichService.update(sandwich), HttpStatus.OK);
    }

    @DeleteMapping(path = "protected/sandwiches/{id}")
    public ResponseEntity<?> remove(@PathVariable Long id){
        this.sandwichService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}