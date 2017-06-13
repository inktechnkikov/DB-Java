package AdvanceJDBC;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String sqlCreate = "CREATE TABLE students(" + "id INT PRIMARY KEY AUTO_INCREMENT, " + "name VARCHAR(20) " + ")";
        String sqlInsert = "INSERT INTO students(id,name)" + "VALUES(1, 'Stamat')";
        String sqlSelect = "SELECT id,name FROM students";
        try {
            Connection connection = DriverManager.getConnection(Constants.SQLCONNECTION,Constants.USER,Constants.PASSWORD);
            Statement statement = connection.createStatement();
         //   statement.executeUpdate(sqlCreate);
          //  statement.executeUpdate(sqlInsert);
            statement.executeQuery(sqlSelect);
         ResultSet resultSet = statement.executeQuery(sqlSelect);
          while (resultSet.next()){
              int id = resultSet.getInt("id");
              String name = resultSet.getString("name");
              System.out.println(String.format("ID->%d Name->%s",id,name));
          }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
