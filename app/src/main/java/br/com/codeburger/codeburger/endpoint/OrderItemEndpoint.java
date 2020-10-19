package br.com.codeburger.codeburger.endpoint;

import br.com.codeburger.codeburger.model.OrderItem;
import br.com.codeburger.codeburger.service.OrderItemService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1")
public class OrderItemEndpoint {

    private final OrderItemService orderItemService;

    @GetMapping(path = "protected/order-items")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(this.orderItemService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "protected/order-items/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(this.orderItemService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "protected/order-items")
    public ResponseEntity<?> create(@RequestBody OrderItem orderItem){
        return new ResponseEntity<>(this.orderItemService.create(orderItem), HttpStatus.CREATED);
    }

    @PutMapping(path = "protected/order-items")
    public ResponseEntity<?> update(@RequestBody OrderItem orderItem){
        this.orderItemService.update(orderItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "protected/order-items/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        this.orderItemService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
