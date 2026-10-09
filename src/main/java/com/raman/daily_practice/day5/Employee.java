package com.raman.daily_practice.day5;

public class Employee {
    public Long id;
    public String name;
    public String depot;
    public double sal;
    public Employee(Long id,String name,String depot,double sal){
        this.id=id;
        this.name=name;
        this.depot=depot;
        this.sal=sal;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", depot='" + depot + '\'' +
                ", sal=" + sal +
                '}';
    }

}
