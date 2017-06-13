
import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test-db");
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        Student john = new Student("John",new Date());
        Student pesho = new Student("Pesho",new Date());
        manager.persist(john);
      //  manager.remove(john);
        manager.persist(pesho);
        manager.getTransaction().commit();
    }
}
