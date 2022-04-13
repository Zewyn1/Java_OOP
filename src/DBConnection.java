import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static Connection conn = null;

    static Connection getConnection() {
        try {
            Class.forName("org.h2.Driver");
            conn= DriverManager.getConnection("jdbc:h2:C:\\Users\\mandy\\IdeaProjects\\Java_OOP\\PersonDB","sa","123");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
