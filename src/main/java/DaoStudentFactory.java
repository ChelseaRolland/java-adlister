public class DaoStudentFactory {
    private static Students studentsDao;

    public static Students getStudentsDao() {
        if (studentsDao == null) {
            studentsDao = new ListStudents();
        }
        return studentsDao;
    }
}
