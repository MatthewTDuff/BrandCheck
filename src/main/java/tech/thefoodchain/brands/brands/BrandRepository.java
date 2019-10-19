package tech.thefoodchain.brands.brands;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.upc12 = ?1")
    Product findByUPC(long upc12);

    @Query("SELECT p FROM Product p WHERE lower(p.brand) LIKE %?1%")
    List<Product> findByBrand(String brand);

}
