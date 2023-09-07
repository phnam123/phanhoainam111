package looking.demo.controller;

import looking.demo.entitles.Product;
import looking.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    final ProductService productService;
    @Autowired
    public ProductController(ProductService productServce){
        this.productService = productServce;
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll()
    {
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Product product){
        return ResponseEntity.ok(productService.update(product));

    }
    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody Product product){
        return ResponseEntity.ok(productService.insert(product));

    }
    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id){
        return ResponseEntity.ok(productService.delete(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name) {
        Product product = productService.getProductByName(name);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}