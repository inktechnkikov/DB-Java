package Transactions;

import Transactions.SQLTransactions.TransConst;

import java.sql.*;

public class Main {

    public static final String sqlInsert = "INSERT INTO students(id,name)" + "VALUES (4,'Tom')";
    public static final String sqlTransaction = "SELECT id,name FROM students";
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(TransConst.URL,TransConst.USER,TransConst.PASS);
            Statement statement = connection.createStatement();
           // connection.setAutoCommit(false);
           // statement.executeUpdate(sqlInsert);
            statement.executeQuery(sqlTransaction);
            ResultSet resultSet = statement.executeQuery(sqlTransaction);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(String.format("ID ->%d Name -> %s",id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
