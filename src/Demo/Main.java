package Demo;
import DBConstants.DBConst;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String sql = "SELECT * FROM world.city";
        try {
            Connection connection = DriverManager.getConnection(DBConst.URLtoDB,DBConst.USER,DBConst.PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("ID");
                String cityName = resultSet.getString("Name");
                String countryCode = resultSet.getString("CountryCode");

                System.out.println(String.format("Town ID %d,Town name %s,CountryCode %s",id,cityName,countryCode));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
