package Transactions.connection;
import Transactions.SQLTransactions.TransConst;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(TransConst.URL,TransConst.USER,TransConst.PASS);
    }
}
