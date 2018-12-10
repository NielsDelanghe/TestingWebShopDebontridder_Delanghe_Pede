package domain.model;

import domain.db.PersonDbInMemory;
import domain.db.PersonDbSQL;
import domain.db.ProductDbSQL;

import java.util.List;

public class ShopService {
    private PersonDbSQL personDb = new PersonDbSQL();
    private ProductDbSQL productDb = new ProductDbSQL();

    public ShopService() {
    }

    public Person getPerson(String personId) {
        return personDb.get(personId);
    }

    public List<Person> getPersons() {
        return personDb.getAll();
    }

    public void addPerson(Person person) {
        personDb.add(person);
    }

    public void updatePersons(Person person) {
        personDb.update(person);
    }

    public void deletePerson(String id) {
       personDb.delete(id);
    }

    private PersonDbSQL getPersonDb() {
        return personDb;
    }

    public Product getProduct(int productid) { return productDb.get(productid); }

    public List<Product> getProducts() { return productDb.getAll(); }

    public void addProduct(Product product) { productDb.add(product); }

    public void updateProduct(Product product) { productDb.update(product); }

    public void deleteProduct(int id) { productDb.delete(id); }


}
