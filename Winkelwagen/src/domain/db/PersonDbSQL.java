package domain.db;

import domain.model.Person;
import domain.model.Role;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PersonDbSQL implements PersonDb{

    private Properties properties = new Properties();
    String url = "jdbc:postgresql://databanken.ucll.be:51819/2TX33?currentSchema=r0702754";

    public PersonDbSQL()
    {
        properties.setProperty("user", "local_r0702754");
        properties.setProperty("password", "ClEX7FpFl-U4yQ");
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
    public Person get(String personId) {
        Person p = new Person();
        Role r;
        try(Connection connection = DriverManager.getConnection(url,properties);
            Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT * FROM person WHERE userid = '"+personId+"' order by userid desc ");
            System.out.println("SELECT * FROM person WHERE userid = '"+personId+"'");
            while (result.next())
            {
                String id = result.getString("userid");
                String firstname = result.getString("firstname");
                String lastname = result.getString("lastname");
                String  email = result.getString("email");
                String password = result.getString("password");
                String role =  result.getString("role");
                if(role.equals("ADMIN"))
                {
                   r = Role.ADMIN;
                }
                else
                {
                    r=Role.CUSTOMER;
                }
                p = new Person(id,email,password,firstname,lastname);
                p.setRole(r);

            }

        }catch(SQLException e){
            throw new DbException(e.getMessage(),e);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return p;
    }

    @Override
    public List<Person> getAll() {
        List<Person> persons = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url,properties);
        Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery("SELECT * FROM person");
            while (result.next()){
                String id = result.getString("userid");
                String firstname = result.getString("firstname");
                String lastname = result.getString("lastname");
                String  email = result.getString("email");
                String password = result.getString("password");
                Person person = new Person(id,email,password,firstname,lastname);
                persons.add(person);
            }

        }catch(SQLException e){
            throw new DbException(e.getMessage(),e);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return persons;
    }

    @Override
    public void add(Person person) {
        if (person == null) {
            throw new DbException("Nothing to add.");
        }
        String sql = "INSERT INTO person(userid,email,password,firstname,lastname,role)"+ "VALUES (?,?,?,?,?,?)";
        try (Connection connection = DriverManager.getConnection(url, properties);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, person.getUserid());
            statement.setString(2, person.getEmail());
            statement.setString(3, person.getPassword());
            statement.setString(4, person.getFirstName());
            statement.setString(5, person.getLastName());
            statement.setString(6,person.getRole().toString());
            statement.execute();
        } catch (SQLException e) {
            throw new DbException(e);
        }
    }

    @Override
    public void update(Person person) {

        String sql ="UPDATE person set email=?,firstname=?,lastname=? WHERE userid=?";
    try(Connection connection = DriverManager.getConnection(url,properties);
    PreparedStatement statement = connection.prepareStatement(sql)) {
        //String sql = "UPDATE person set email ='"+person.getEmail()+"', firstname = '"+person.getFirstName()+"', lastname = '"+person.getLastName()+"'  WHERE userid ='"+person.getUserid()+"'";
        statement.setString(1,person.getEmail());
        statement.setString(2,person.getFirstName());
        statement.setString(3,person.getLastName());
        statement.setString(4,person.getUserid());
        System.out.println(sql);
        statement.execute();

    }catch (SQLException e){
        throw new DbException(e.getMessage(),e);
        }

    }

    @Override
    public void delete(String personId) {

        String sql ="DELETE FROM person WHERE userid =?";
        try(Connection connection = DriverManager.getConnection(url,properties);
            PreparedStatement statement = connection.prepareStatement(sql)) {
            //statement.execute("DELETE FROM person WHERE userid = '"+personId+"'");
            statement.setString(1,personId);
            statement.execute();

        }catch(SQLException e){
            throw new DbException(e.getMessage(),e);
        }

    }

    @Override
    public int getNumberOfPersons() {
        List<Person> persons = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url,properties);
            Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery("SELECT * FROM person");
            while (result.next()){
                String id = result.getString("userid");
                String firstname = result.getString("firstname");
                String lastname = result.getString("lastname");
                String  email = result.getString("email");
                String password = result.getString("password");
                Person person = new Person(id,email,password,firstname,lastname);
                System.out.println(person.toString());
            }

        }catch(SQLException e){
            throw new DbException(e.getMessage(),e);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return persons.size();
    }
}
