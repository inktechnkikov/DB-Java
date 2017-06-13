package entities;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "registration_date")
    private Date registrationDate;

    public Student(){

    }
    public Student(String firstName,Date registrationDate){
        this.firstName = firstName;
        this.registrationDate = registrationDate;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public Date getRegistrationDate(){
        return this.registrationDate;
    }
    public void setRegistrationDate(Date registrationDate){
        this.registrationDate = registrationDate;
    }
}
