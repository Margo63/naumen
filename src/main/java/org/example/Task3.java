package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task3 implements TaskRunner{
    List<Employee> employees;
    private void init(){
        employees = new ArrayList<>();
        employees.add(new Employee("Ivanov", 20,"department 1", 10000.0));
        employees.add(new Employee("Smirnov", 48,"department 2", 255735.435));
        employees.add(new Employee("Sidorov", 37,"department 1", 235.345));
        employees.add(new Employee("Nikolaev", 77,"department 2", 123455.22));
        employees.add(new Employee("Petrov", 18,"department 3", 230457.86));
    }
    private List<Employee> sort(){
        return employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).toList();
    }
    public void run(){
        init();
        System.out.println("current list of employers" + employees);
        List<Employee> sortedEmployers =  sort();
        System.out.println("sorted list of employers" + sortedEmployers);
    }
}