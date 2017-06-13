package Transactions.dao;

import Transactions.SQLTransactions.TransConst;
import Transactions.connection.DBConnection;
import Transactions.interfaces.StudentDao;
import Transactions.models.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao{
    private List<Student> studentList;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public StudentDaoImpl(){
        this.studentList = new ArrayList<>();
    }
    @Override
    public List<Student> getAllStudents() throws SQLException {
       this.connection = DBConnection.getConnection();
       this.preparedStatement = connection.prepareStatement(TransConst.sqlSelect);
       this.resultSet = preparedStatement.executeQuery();
       while (resultSet.next()){
           int id = resultSet.getInt("id");
           String name = resultSet.getString("name");
           Student student = new Student();
           student.setId(id);
           student.setName(name);
           this.studentList.add(student);
       }
       return this.studentList;
    }

    @Override
    public void insertStudent(Student student) throws SQLException {
        this.connection = DBConnection.getConnection();
        this.preparedStatement = connection.prepareStatement(TransConst.sqlInsert);
        int id = student.getId();
        this.preparedStatement.setInt(1,id);
        String name = student.getName();
        this.preparedStatement.setString(2,name);
        this.preparedStatement.execute();
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        this.connection = DBConnection.getConnection();
        this.preparedStatement = connection.prepareStatement(TransConst.sqlUpdate);
        int id = student.getId();
        String name = student.getName();
       this.preparedStatement.setString(1,name);
       this.preparedStatement.setInt(2,id);
       this.preparedStatement.execute();
    }

    @Override
    public void deleteStudent(Student student) throws SQLException {
        this.connection = DBConnection.getConnection();
        this.preparedStatement = connection.prepareStatement(TransConst.sqlDelete);
        int id=student.getId();
        this.preparedStatement.setInt(1,id);
        this.preparedStatement.execute();
    }

    @Override
    public void close() throws Exception {
        if(this.resultSet != null){
            this.resultSet.close();
        }
        if(preparedStatement != null){
            this.preparedStatement.close();
        }
        if(this.connection != null){
            this.connection.close();
        }

    }
}
