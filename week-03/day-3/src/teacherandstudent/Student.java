package teacherandstudent;

public class Student {
    public void learn() {
        System.out.println("I'm learning math.");

    }

    public void question(Teacher teacher) {
        System.out.println("Excuse me, I'd like to ask...");
        teacher.answer();
    }
}
