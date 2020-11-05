public class Student {
    //This is a BEAN

    private static long studentCount = 0;

    private String firstName;
    private String lastName;
    private String cohort;
    private long id;

    //Empty Constructor
    public Student() {}

    //Additional Info Constructor
    public Student(String aFirstName, String aLastName, String aCohort){
        studentCount++;
        this.id = studentCount;
        this.firstName = aFirstName;
        this.lastName = aLastName;
        this.cohort = aCohort;
    }

    //getters
    public String getFirstName () {
        return this.firstName;
    }

    public String getLastName () {
        return this.lastName;
    }

    public String getCohort () {
        return this.cohort;
    }

    public long getId() {
        return this.id;
    }

    //setters
    public void setFirstName (String aFirstName){
        this.firstName = aFirstName;
    }

    public void setLastName (String aLastName){
        this.lastName = aLastName;
    }

    public void setCohort (String aCohort){
        this.cohort = aCohort;
    }

    public void setId(long id) {
        this.id = id;
    }
}
