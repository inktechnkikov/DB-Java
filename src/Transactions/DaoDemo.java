package Transactions;

import Transactions.dao.StudentDaoImpl;
import Transactions.interfaces.StudentDao;
import Transactions.models.Student;

import java.sql.SQLException;

public class DaoDemo {
    public static void main(String[] args) {
        try(StudentDao studentDao = new StudentDaoImpl()) {
          //  Student student = new Student();
         //   student.setName("Pesho");
          //  studentDao.insertStudent(student);
            studentDao.getAllStudents().forEach(f->{
                Student student = new Student();
                if(f.getId() == 5){
                    student.setName("Minka");
                    try {
                        studentDao.updateStudent(student);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
