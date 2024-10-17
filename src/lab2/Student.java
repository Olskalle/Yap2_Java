package lab2;

class Student {
    private String name;
    private int[] grades;

    public Student(String name, int[] grades) {
        this.name = name;
        this.grades = grades;
    }

    public int[] getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return name + ": " + java.util.Arrays.toString(grades);
    }
}