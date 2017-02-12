package lamdas.sort;

public class Student {
    private String name;
    private String departmentName;
    private int totalMarks;

    public Student(String name, String departmentName, int totalMarks) {
        this.name = name;
        this.departmentName = departmentName;
        this.totalMarks = totalMarks;
    }

    public String getName() {
        return name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", totalMarks=" + totalMarks;
    }
}
