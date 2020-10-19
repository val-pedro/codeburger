package br.com.codeburger.codeburger.endpoint;

import br.com.codeburger.codeburger.model.Order;
import br.com.codeburger.codeburger.service.OrderService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1")
public class OrderEndpoint {

    OrderService orderService;

    @Autowired
    public OrderEndpoint(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = "protected/orders")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity(this.orderService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "protected/orders/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(this.orderService.findById(id),HttpStatus.OK);
    }

    @PostMapping(path = "protected/orders")
    public ResponseEntity<?> create(@RequestBody Order order){
        return new ResponseEntity<>(this.orderService.create(order), HttpStatus.OK);
    }

    @PutMapping(path = "protected/orders")
    public ResponseEntity<?> update(@RequestBody Order order){
        this.orderService.update(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "protected/orders/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
