import java.util.List;

//DAO Interface --> Describes what methods we have

public interface Students {
        List<Student> all(); // get all the product records
        void insert(Student student); // persist new product to the database
        void update (Student student);
        void destroy (Student student);
}
