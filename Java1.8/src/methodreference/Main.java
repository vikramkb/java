package methodreference;

import lamdas.sort.Student;

public class Main {
    public static void main(String[] args) {


        Students students = new Students();
        System.out.println("****** all students : reference to an instance method of an object of particular type *****************");
        System.out.println();
        students.forEach(Student::print);

        System.out.println();
        System.out.println("****** students > 90 : reference to a static method *****************");
        System.out.println();
        students.forEach(Main::marksGreaterThanNinty);

        /* println is the method of out object. student object will be passed to println. toString will be called on student */
        System.out.println();
        System.out.println("****** students > 90 : reference to a method of particular object *****************");
        System.out.println();
        students.forEach(System.out::println);
    }

    public static void marksGreaterThanNinty(Student student) {
        if(student.getTotalMarks() > 90) {
            student.print();
        }
    }
}
