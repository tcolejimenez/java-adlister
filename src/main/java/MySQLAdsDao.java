/* Create a class named MySQLAdsDao that implements the Ads interface:
 *
 * This class should have a private instance property named connection
 * of type Connection that is initialized in the constructor.
 *
 * Define your constructor so that it accepts an instance of your Config class
 * so that it can obtain the database credentials.
 *
 * Implement the methods in the Ads interface:
 *
 * Your methods should retrieve ads from the database and insert new ads into the database
 *
 * The connection object will be created just once, in this class' constructor,
 * and the individual methods that query the database should use the connection object to create statements.
 */

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection;
    private List<Ad> ads = new ArrayList<>();

    public MySQLAdsDao(Config config) throws SQLException {
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());

    }

    public List<Ad> all() {
        String selectAllQuery = "SELECT * FROM ads";
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(selectAllQuery);
            while (results.next()) {
                ads.add(new Ad(
                        results.getLong("id"),
                        results.getLong("user_id"),
                        results.getString("title"),
                        results.getString("description")
                        )
                );
            }
        }
        catch (SQLException e) {
            System.out.println("Didn't work...");
        }

        return ads;
    }

    public Long insert(Ad ad) {
        return 2L;
    }

}
