package com.raman.daily_practice.day5.GroupingPartitioning;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningBy {

    public static void main(String[] args){
        List<Integer> list= Arrays.asList(2,3,4,5,1,10,8,20,30,18,7);
        Map<Boolean,List<Integer>> result = list.stream()
                .collect(Collectors.partitioningBy(n->n>10));
        System.out.println(result);

        List<Employee> listEmp = Arrays.asList(new Employee(1L,"Raman","IT"),
                new Employee(2L,"Hari","IT"),
                new Employee(3L,"Ramesh","NIT"),
                new Employee(4L,"Ragu","NIT"));

        Map<Boolean,List<Employee>> itEmployee=listEmp.stream()
                .collect(Collectors.partitioningBy(emp->emp.depot=="IT"));
        System.out.println(itEmployee);
    }

}
