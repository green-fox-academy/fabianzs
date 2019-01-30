package teacherandstudent;

public class TeacherAndStudent {
    public static void main(String[] args) {
        Teacher mathTeacher = new Teacher();
        Student newStudent = new Student();

        newStudent.question(mathTeacher);

        mathTeacher.teach(newStudent);

    }
}
