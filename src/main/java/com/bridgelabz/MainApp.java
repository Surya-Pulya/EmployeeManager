package com.bridgelabz;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();

        while (true) {
            System.out.println("\n1. Add Employee\n2. Update Employee\n3. Delete Employee\n4. View Employee\n5. View All Employees\n6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID, Name, Salary: ");
                        int id = sc.nextInt();
                        sc.nextLine(); // consume newline
                        String name = sc.nextLine();
                        double salary = sc.nextDouble();
                        sc.nextLine(); // consume newline
                        System.out.print("Is Permanent? (yes/no): ");
                        String type = sc.nextLine();
                        Employee emp = type.equalsIgnoreCase("yes") ?
                                new PermanentEmployee(id, name, salary) :
                                new ContractEmployee(id, name, salary);
                        manager.addEmployee(emp);
                        break;

                    case 2:
                        System.out.print("Enter ID to update: ");
                        int uid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new Name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new Salary: ");
                        double newSalary = sc.nextDouble();
                        manager.updateEmployee(uid, newName, newSalary);
                        break;

                    case 3:
                        System.out.print("Enter ID to delete: ");
                        int did = sc.nextInt();
                        manager.deleteEmployee(did);
                        break;

                    case 4:
                        System.out.print("Enter ID to view: ");
                        int vid = sc.nextInt();
                        Employee e = manager.getEmployee(vid);
                        e.displayDetails();
                        break;

                    case 5:
                        manager.displayAllEmployees();
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (EmployeeNotFoundException ex) {
                System.out.println("Error: " + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Unexpected error: " + ex.getMessage());
            } finally {
                System.out.println("Operation completed.\n");
            }
        }
    }
}
