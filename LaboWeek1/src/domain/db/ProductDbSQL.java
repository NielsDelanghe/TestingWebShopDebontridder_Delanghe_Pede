package domain.db;

import domain.model.Person;
import domain.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductDbSQL implements ProductDb{

    private Properties properties = new Properties();
    String url = "jdbc:postgresql://databanken.ucll.be:51819/2TX33?currentSchema=r0702754";

    public ProductDbSQL()
    {
        properties.setProperty("user", "local_r0702754");
        properties.setProperty("password", "GcAmtb;r²dp-l5C");
        properties.setProperty("ssl", "true");
        properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        properties.setProperty("sslmode","prefer");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    @Override
    public void add(Product product) {
        if (product == null) {
            throw new DbException("Nothing to add.");
        }
        String sql = "INSERT INTO product(productid,name,description,price) VALUES (?,?,?,?)";
        try (Connection connection = DriverManager.getConnection(url, properties);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, product.getProductId());
            statement.setString(2, product.getName());
            statement.setString(3, product.getDescription());
            statement.setDouble(4, product.getPrice());
            statement.execute();
        } catch (SQLException e) {
            throw new DbException(e);
        }
    }

    @Override
    public List<Product> getAll() {
        List<Product> producten = new ArrayList<Product>();
        try (Connection connection = DriverManager.getConnection(url, properties);
             Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery("SELECT * FROM product");
            while (result.next()) {
                String id = result.getString("productid");
                String name = result.getString("name");
                String description = result.getString("description");
                String price = result.getString("price");
                Product product = new Product(Integer.parseInt(id),name,description,Double.parseDouble(price));
                producten.add(product);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
        return producten;
    }

    @Override
    public Product get(int productId)
    {
        String sql = "SELECT * FROM product WHERE productid = ?";
        try (Connection connection = DriverManager.getConnection(url, properties);
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, productId);
            ResultSet result = statement.executeQuery();
            result.next();
            int id = result.getInt("productid");
            String name = result.getString("name");
            String description = result.getString("description");
            String price = result.getString("price");
            Product product = new Product(id,name,description,Double.parseDouble(price));
            return product;
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    @Override
    public void update(Product product)
    {
        String sql = "UPDATE product SET" +
                "name = ?," +
                "description = ?," +
                "price = ?" +
                "WHERE productid = ?";
        try(Connection connection = DriverManager.getConnection(url,properties);
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,product.getName());
            statement.setString(2,product.getDescription());
            statement.setDouble(3,product.getPrice());
            statement.setInt(4,product.getProductId());
            statement.execute();
        }catch (SQLException e){
            throw new DbException(e.getMessage(),e);
        }
    }

    @Override
    public void delete(int productId)
    {
        String sql = "DELETE FROM product WHERE productid = ?";
        try (Connection connection = DriverManager.getConnection(url, properties);
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,productId);
            statement.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage(), e);
        }
    }
}
