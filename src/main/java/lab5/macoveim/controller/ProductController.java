package lab5.macoveim.controller;

import lab5.macoveim.model.Organisation;
import lab5.macoveim.model.Product;
import lab5.macoveim.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable long id) {
        return productRepository.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Product product) {
        productRepository.save(product);
    }

    @DeleteMapping("/{productId}")
    public void delete(@PathVariable long productId) {
        productRepository.delete(productId);
    }

    @PutMapping
    public void update(@RequestBody Product product) { productRepository.update(product); }

}

