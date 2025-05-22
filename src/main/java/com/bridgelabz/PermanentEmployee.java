package com.bridgelabz;

// Inheritance & Polymorphism
public class PermanentEmployee extends Employee {
    public PermanentEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    public void displayDetails() {
        System.out.println("Permanent Employee - ID: " + getId() + ", Name: " + getName() + ", Salary: " + getSalary());
    }
}

