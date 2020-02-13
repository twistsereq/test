import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class App {

    public static void main(String[] args) {

        // Connect to database
        String hostName = "bazazaliczenie2020.database.windows.net:1433"; // update me
        String dbName = "bazazaliczenie2020"; // update me
        String user = "Milena"; // update me
        String password = "K@loryfer123"; // update me
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
            System.out.println("Successful connection - Schema: " + schema);

            System.out.println("Query data example:");
            System.out.println("=========================================");

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT * FROM dbo.Persons ";
               

            try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql)) {

                // Print results from select statement
                System.out.println("wynik  :");
                while (resultSet.next())
                {
                    System.out.println(resultSet.getString(1) + " "
                        + resultSet.getString(2));
                }
                connection.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}