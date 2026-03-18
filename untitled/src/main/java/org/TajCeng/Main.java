package org.TajCeng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
         Employee e = new Employee(1,"Taj",100);
        Employee e1 = new Employee(2,"Raj",200);
        Employee e2 = new Employee(3,"Taj",300);
        Employee e3 = new Employee(4,"Kaj",400);
        Employee e4 = new Employee(5,"Paj",500);
        Employee e5 = new Employee(6,"Taj",600);

         System.out.println(e);
        System.out.println("----------------GETTING DATA WHICH I WANT-------------------------------------------------------------");

        List<Employee> emp = Arrays.asList(e,e1,e2,e3,e4,e5);
        List<Employee> test5 = emp.stream().filter(emp1 -> emp1.getId()==3 || emp1.getId()==5).collect(Collectors.toList());
        System.out.println(test5);
        System.out.println("---------------- second highest DATA-------------------------------------------------------------");
        List<Employee> test6 = emp.stream().filter(emp1 -> emp1.getSalary() >400 && emp1.getSalary() <600).collect(Collectors.toList());
        System.out.println(test6);
        System.out.println("-------------------GETTING DATA WHICH IS GREATER 300----------------------------------------------------------");
List<Employee> test1 = emp.stream().filter(t ->t.salary > 300).collect(Collectors.toList());
System.out.println(test1);
        System.out.println("--------------------------GETTING DATA WHO HAS SAME NAME---------------------------------------------------");
List<Employee> test2 = emp.stream().filter(t ->t.name.equalsIgnoreCase("Taj")).collect(Collectors.toList());
System.out.println(test2);
System.out.println("-----------------------------------------------------------------------------");

        List <Integer> newList =  new ArrayList<>();
        newList.add(6);

    }


}