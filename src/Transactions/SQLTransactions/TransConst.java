package Transactions.SQLTransactions;


public class TransConst {
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/test-db";
    public static final String USER = "nkikov";
    public static final String PASS = "nkikov";
    public static final String sqlSelect = "SELECT * FROM students";
    public static final String sqlInsert = "INSERT INTO students(id,name) " + "VALUES(?,?)";
    public static final String sqlUpdate = "UPDATE students " + "SET name = ? " + "WHERE id = ?";
    public static final String sqlDelete = "DELETE FROM students " + "WHERE id = ?";
}
