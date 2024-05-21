package com.shopify.products.Controller;

import com.shopify.products.Exception.NotFound;
import com.shopify.products.Model.Appliances;
import com.shopify.products.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin("http://localhost:3000")
public class AppliancesController {

    @Autowired
    private ProductRepository product;

    @PostMapping("/add-appliances")
    public Appliances createAppliances(@RequestBody Appliances addAppliances){
        return product.save(addAppliances);
    }

    @GetMapping("/get-all-appliances")
    public List<Appliances> getallAppliances(){
        return product.findAll();
    }

    @PutMapping("/update/{id}")
    public Appliances updateAppliances(@RequestBody Appliances updateAppliances, @PathVariable Long id){
        Appliances appliances = product.findById(id)
                .orElseThrow(() -> new NotFound("Product not found"));

        appliances.setProduct_name(updateAppliances.getProduct_name());
        appliances.setProduct_description(updateAppliances.getProduct_description());
        appliances.setProduct_price(updateAppliances.getProduct_price());

        return product.save(appliances);
    }

    @DeleteMapping("/{id}")
    public void deleteAppliances(@PathVariable Long id){
        Appliances appliances = product.findById(id)
                .orElseThrow(() -> new NotFound("Resource not found"));
        product.delete(appliances);
    }

}
