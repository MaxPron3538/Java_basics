package main;

import main.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductsController {

    @Autowired
    IStorage storage;

    @GetMapping("/products/")
    public ResponseEntity<?> list(){
        return new ResponseEntity<>(storage.getAllProducts(),HttpStatus.OK);
    }

    @PostMapping("/products/")
    public ResponseEntity<?> add(Product product){
        storage.addProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> get(@PathVariable("id") int id){
        Product product = storage.getProduct(id);
        return product != null ?
                new ResponseEntity<>(product,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<?> update(Product product,@PathVariable int id){
        boolean updated = storage.updateProduct(product,id);
        return updated ? new ResponseEntity<>(HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        boolean deleted = storage.deleteProduct(id);
        return deleted ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/products/")
    public ResponseEntity<?> deleteList(){
        storage.deleteAllProducts();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
