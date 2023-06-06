package be.ehb.derdehands.dao;

import be.ehb.derdehands.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Product, Integer> {
}
