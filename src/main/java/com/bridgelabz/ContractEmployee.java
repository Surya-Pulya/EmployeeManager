package com.bridgelabz;

public class ContractEmployee extends Employee {
    public ContractEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    public void displayDetails() {
        System.out.println("Contract Employee - ID: " + getId() + ", Name: " + getName() + ", Salary: " + getSalary());
    }
}
