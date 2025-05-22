package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;

public class EmployeeManager {
    private Map<Integer, Employee> employeeMap = new HashMap<>();

    public void addEmployee(Employee e) {
        employeeMap.put(e.getId(), e);
    }

    public void updateEmployee(int id, String newName, double newSalary) throws EmployeeNotFoundException {
        if (!employeeMap.containsKey(id)) {
            throw new EmployeeNotFoundException("Employee ID not found.");
        }
        Employee e = employeeMap.get(id);
        e.setName(newName);
        e.setSalary(newSalary);
    }

    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        if (!employeeMap.containsKey(id)) {
            throw new EmployeeNotFoundException("Employee ID not found.");
        }
        employeeMap.remove(id);
    }

    public Employee getEmployee(int id) throws EmployeeNotFoundException {
        if (!employeeMap.containsKey(id)) {
            throw new EmployeeNotFoundException("Employee ID not found.");
        }
        return employeeMap.get(id);
    }

    public void displayAllEmployees() {
    	if (employeeMap.isEmpty()) {
    		System.out.println("There are no employees in the database.");
    	}
    	else {
        for (Employee e : employeeMap.values()) {
            e.displayDetails();
            if (e instanceof PermanentEmployee) {
                System.out.println(" -> Type: Permanent");
            } else if (e instanceof ContractEmployee) {
                System.out.println(" -> Type: Contract");
            }
        }
    	}
    }
}
