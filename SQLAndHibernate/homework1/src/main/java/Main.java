import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "********";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement statement = connection.createStatement()) {

            String sql = "select pl.course_name,\n" +
                    "count(pl.course_name)/(max(month(pl.subscription_date))+1 - min(month(pl.subscription_date)))\n" +
                    "from purchaselist pl group by pl.course_name";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " - " + resultSet.getDouble(2));
            }

            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
