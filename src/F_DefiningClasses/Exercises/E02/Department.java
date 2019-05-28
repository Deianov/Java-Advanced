package F_DefiningClasses.Exercises.E02;

import java.util.*;

class Department {
    private static Map<String, List<Employee>> employees;

    static void init() {
        Department.employees = new HashMap<>();
    }

    static void add(Employee employee) {
        Department.employees.putIfAbsent(employee.getDepartment(), new ArrayList<>());
        Department.employees.get(employee.getDepartment()).add(employee);
    }

    static void printHighest() {
        Department.employees
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().stream().mapToDouble(Employee::getSalary).average().orElse(0.0)))
                .ifPresent(entry -> {
                    System.out.println(String.format("Highest Average Salary: %s", entry.getKey()));
                    entry.getValue()
                            .stream()
                            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                            .forEach(e -> System.out.println(e.toString()));
                });
    }
}
