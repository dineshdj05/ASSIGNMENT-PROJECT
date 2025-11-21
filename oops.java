class Student {
    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void display(){
        System.out.println("Student ID: " + id + ", Name: " + name);
    }
}

public class StudentM {
    public static void main(String[] args) {
        Student student1 = new Student("rahul", 101);
        Student student2 = new Student("guru"102);

        student1.display()
        student2.display();
    }
}