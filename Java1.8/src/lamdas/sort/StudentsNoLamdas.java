package lamdas.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentsNoLamdas {

    private List<Student> students = Arrays.asList(new Student("ram", "CS", 94), new Student("laxman", "EC", 80), new Student("ashok", "CS", 90), new Student("nag", "ME", 60), new Student("vignesh", "CS", 99));

    public void sortByName() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
    }
    public void sortByDepartmentName() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getDepartmentName().compareTo(s2.getDepartmentName());
            }
        });
    }
    public void sortByMarks() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.getTotalMarks(), s2.getTotalMarks());
            }
        });
    }

    public void printStudents() {
        for (Student student:students) {
            System.out.println(student.getName() + ", " + student.getDepartmentName() + ", " + student.getTotalMarks());
        }
    }

}
