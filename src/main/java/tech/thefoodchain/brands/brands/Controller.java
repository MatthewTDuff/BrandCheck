package tech.thefoodchain.brands.brands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EntityScan
public class Controller {

    @Autowired
    BrandRepository brandRepository;



    @GetMapping("/id/{id}")
    public Product productById(@PathVariable int id){

        return brandRepository.getOne(id);
    }

    @GetMapping("/{upc}")
    public Product productByUpc(@PathVariable long upc){

        System.out.println(upc);
        if(brandRepository.findByUPC(upc) == null){
            System.out.println("Found nothing");
        }
        return brandRepository.findByUPC(upc);
    }

    @GetMapping("/brand/{brand}")
    public List<Product> productByUpc(@PathVariable String brand){
        brand = brand.toLowerCase();
        return brandRepository.findByBrand(brand);
    }

}
