package fabian.zsofia.hundredacrewood.models;

public class Inhabitant {

    private static int nextId = 1;
    private int id;
    private String name;
    private int age;
    private Gender gender;

    public Inhabitant() {
    }

    public Inhabitant( String name, int age, Gender gender) {
        this.id = nextId++;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public static void setNextId(int nextId) {
        Inhabitant.nextId = nextId;
    }

    public void setId(int id) {
        this.id = nextId++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
