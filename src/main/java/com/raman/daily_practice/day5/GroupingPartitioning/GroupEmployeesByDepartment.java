package com.raman.daily_practice.day5.GroupingPartitioning;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

 class Employee{
    Long id;
     String name;
     String depot;

     Employee(Long id,String name,String depot){
         this.id=id;
         this.name=name;
         this.depot=depot;
     }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" +id+ '\'' +
                "name='" + name + '\'' +
                ", depot='" + depot + '\'' +
                '}';
    }


}
public class GroupEmployeesByDepartment {

    public static void main(String[] args){
        Random random= new Random();
        List<Employee> list= Arrays.asList(new Employee(random.nextLong(1000),"Raman", "it"),
                new Employee(random.nextLong(1000),"Hari", "VM"),
                new Employee(random.nextLong(100),"vamsi","testing"),
                new Employee(random.nextLong(),"Ramesh","it")
        );

        Map<Long,List<Employee>> result=list.stream()
                .collect(Collectors.groupingBy(e->e.id));
        System.out.println(result);

        /**
         * Order by Depot
         */
        Map<String,List<Employee>> resultDepot = list.stream()
                .collect(Collectors.groupingBy(emp->emp.depot));
        System.out.println(resultDepot);

        /**
         * find count of each department
         * this is called downstream
         */
        Map<String ,Long> count=list.stream()
                .collect(Collectors.groupingBy(emp->emp.depot,Collectors.counting()));
        System.out.println(count);


    }
}
