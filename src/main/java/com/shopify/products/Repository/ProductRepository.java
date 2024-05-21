package com.shopify.products.Repository;

import com.shopify.products.Model.Appliances;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Appliances, Long> {
}
