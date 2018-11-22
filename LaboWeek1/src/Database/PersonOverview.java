package Database;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//import domain.db.Secret;
import domain.model.Person;

import javax.swing.*;

public class PersonOverview {
    public static void main(String[] args) throws SQLException {

        String Insertid = JOptionPane.showInputDialog("Geef het id in van de persoon");
        String Insertemail = JOptionPane.showInputDialog("Geef het email adres in");
        String Insertfn = JOptionPane.showInputDialog("Geef de voornaam van de persoon");
        String Insertln = JOptionPane.showInputDialog("Geef de achternaam van de persoon");
        String Insertpass = JOptionPane.showInputDialog("Geef het passwoord in");

        Properties properties = new Properties();
        String url = "jdbc:postgresql://databanken.ucll.be:51819/2TX33?currentSchema=r0702754";
        properties.setProperty("user", "local_r0702754");
        properties.setProperty("password", "GcAmtb;r²dp-l5C");
        //Secret.setPass(properties);	// implements line 17 and 18
        properties.setProperty("ssl", "true");
        properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        properties.setProperty("sslmode","prefer");

        Connection connection = DriverManager.getConnection(url,properties);
        Statement statement = connection.createStatement();

        try{
            statement.execute("INSERT INTO PERSON(userid,email,password,firstname,lastname)"+ "VALUES " + "('" + Insertid + "',' " + Insertemail + "',' " + Insertpass + "',' " + Insertfn+"','"+Insertln +"')");
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        ResultSet result = statement.executeQuery( "SELECT * FROM person" );


        while(result.next()){
            String id = result.getString("userid");
            String firstname = result.getString("firstname");
            String lastname = result.getString("lastname");
           String  email = result.getString("email");
           String password = result.getString("password");
            try {	// validation of data stored in database
                Person person = new Person(id,email,password,firstname,lastname);
                System.out.println(person.toString());
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        statement.close();
        connection.close();
    }
}
