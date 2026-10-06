package com.raman.daily_practice.day_4;


import java.time.temporal.Temporal;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee{
    private String name;
    private String department;
    private double salary;

    public Employee(String name,String department,double salary){
        this.name=name;
        this.department=department;
        this.salary=salary;
    }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", department='" + department + '\'' +
                    ", salary=" + salary +
                    '}';
        }


    public String getName(){
        return name;
    }
    public String getDepartment(){
        return department;
    }
    public double getSalary() {
        return salary;
    }

}
public class EmployeeGroupingBy {
    public static void main(String[] ag) {
        List<Employee> list = Arrays.asList(
                new Employee("Raman", "IT", 15000),
                new Employee("Shyam", "IT", 25000),
                new Employee("Narasimhan", "MECH", 20000)
        );

        Map<String, List<Employee>> result = list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println(result);


        /**
         * now it's time for counting only
         */

        Map<String, Long> resultCount = list.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()));
        System.out.println(resultCount);

        /**
         * Find Highest-Paid Employee Per Department
         */

        Employee emp= list.stream()
                .max((e1,e2)->Double.compare(e1.getSalary(),e2.getSalary()))
                .orElse(null);
        System.out.println(emp);

        /**
         * finding minimum sal
         */
        Employee minSal = list.stream()
                .min((emp1,emp2)->Double.compare(emp1.getSalary(),emp2.getSalary()))
                .orElse(null);
        System.out.println(minSal);

        /**
         * Finding The Highest Paid employee in the Each Department
         */

        Map<String, Optional<Employee>> highestDep = list.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));
        System.out.println(highestDep);






    }
}
