package F_DefiningClasses.Exercises.Е02;

class Employee {
    private static final String UNDEFINED_VALUE_STRING = "n/a";
    private static final int UNDEFINED_VALUE_INTEGER = -1;

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    Employee(String name, double salary, String position, String department, String email, Integer age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email != null ? email : UNDEFINED_VALUE_STRING;
        this.age = age != null ? age : UNDEFINED_VALUE_INTEGER;
    }

    double getSalary() { return salary; }
    String getDepartment() { return department; }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
