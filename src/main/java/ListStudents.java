import java.util.ArrayList;
import java.util.List;

public class ListStudents implements Students{
    private List<Student> students = new ArrayList<Student>();

    public ListStudents(){
        insert(new Student("coven", "timeless", "bash"));
        insert(new Student("naruto", "uzumaki", "bash"));
        insert(new Student("itachi", "uchiha", "bash"));
    }

    public List<Student> all(){
        return this.students;
    }

    public void insert (Student student) {
        this.students.add(student);
    }

    public void update (Student student){
        // first look up quote from quotes (maybe by id)
        // then replace with new value
        System.out.println("");
    }

    public void destroy (Student student) {
        // first look up quote from quotes (maybe by id)
        // quotes.remove(quote)
        System.out.println("");
    }
}
