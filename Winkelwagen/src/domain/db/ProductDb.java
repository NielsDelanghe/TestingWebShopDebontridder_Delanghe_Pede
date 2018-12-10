package domain.db;


import domain.model.Product;

import java.util.List;

public interface ProductDb {

    Product get(int productId);

    List<Product> getAll();

    void add(Product product);

    void update(Product product);

    void delete(int productId);
}
