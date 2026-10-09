package com.raman.daily_practice.day5.SortingComparators;





import com.raman.daily_practice.day5.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortEmployeesBySalary {


    public static void main(String[] args){
        List<Employee> empList = Arrays.asList(new Employee(1L,"Raman","IT",15000),
                new Employee(2L,"Ragu","NIT",20000),
                new Employee(3L,"Ramesh","IT",30000),
                new Employee(4L,"sri","NIT",16000));
       List<Employee> result=empList.stream()
               .sorted(Comparator.comparingDouble(e->e.sal))
               .toList();

       System.out.println(result);

    }
}
