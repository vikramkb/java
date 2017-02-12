package lamdas.sort;

public class Main {
    public static void main(String args[]) {
        System.out.println("******************************* no lamdas *******************************");
        StudentsNoLamdas studentsNoLamdas = new StudentsNoLamdas();
        System.out.println("--------------- students ---------------");
        studentsNoLamdas.printStudents();
        studentsNoLamdas.sortByName();
        System.out.println("--------------- sort by name ---------------");
        studentsNoLamdas.printStudents();

        studentsNoLamdas.sortByDepartmentName();
        System.out.println("--------------- sort by department name ---------------");
        studentsNoLamdas.printStudents();

        studentsNoLamdas.sortByMarks();
        System.out.println("--------------- sort by marks ---------------");
        studentsNoLamdas.printStudents();


        System.out.println("******************************* using lamdas *******************************");
        StudentsLamdas studentsLamdas = new StudentsLamdas();
        System.out.println("--------------- students ---------------");
        studentsLamdas.printStudents();

        studentsLamdas.sort((Student s1, Student s2) -> s1.getName().compareTo(s2.getName()));
        System.out.println("--------------- sort by name ---------------");
        studentsLamdas.printStudents();

        studentsLamdas.sort((Student s1, Student s2) -> s1.getDepartmentName().compareTo(s2.getDepartmentName()));
        System.out.println("--------------- sort by department name ---------------");
        studentsLamdas.printStudents();

        studentsLamdas.sort((Student s1, Student s2) -> Integer.compare(s1.getTotalMarks(), s2.getTotalMarks()));
        System.out.println("--------------- sort by marks ---------------");
        studentsLamdas.printStudents();
    }
}
