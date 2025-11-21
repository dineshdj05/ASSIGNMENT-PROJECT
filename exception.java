class InStudent extends Exception {
    public InStudent(String message) {
        super(message);
    }
}

class Student {
    private String name;
    private int id;

    public Student(String name, int id) throws InStudent {
        if (name == null || name.isEmpty()) {
            throw new InStudent("Name cannot be null or empty");
        }
        if (id <= 0) {
            throw new InStudent("ID must be positive");
        }
        this.name = name;
        this.id = id;
    }

    public void displayStudent() {
        System.out.println("Student ID: " + id + ", Name: " + name);
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        try {
            Student student1 = new Student("Aakash",1);
            Student student2 = new Student("Arun",2);
            student1.displayStudent();
            student2.displayStudent();
        } catch (InStudent e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}