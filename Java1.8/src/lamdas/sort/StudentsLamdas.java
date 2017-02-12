package lamdas.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentsLamdas {

    private List<Student> students = Arrays.asList(new Student("ram", "CS", 94), new Student("laxman", "EC", 80), new Student("ashok", "CS", 90), new Student("nag", "ME", 60), new Student("vignesh", "CS", 99));

    public void sort(SortCriteria<Student, Student> sortCriteria) {
        Collections.sort(students, (Student s1, Student s2) -> sortCriteria.compare(s1, s2));
    }

    public void printStudents() {
        for (Student student:students) {
            System.out.println(student.getName() + ", " + student.getDepartmentName() + ", " + student.getTotalMarks());
        }
    }

    public void forEach() {

    }
}
