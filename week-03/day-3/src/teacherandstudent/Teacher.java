package teacherandstudent;

public class Teacher {
    public void teach(Student student) {
        System.out.println("I'm teaching you maths.");
        student.learn();

    }

    public void answer() {
        System.out.println("The answer for your question is...");

    }
}
