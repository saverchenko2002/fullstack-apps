package employeemanager.service;

import employeemanager.entity.Employee;
import employeemanager.exception.UserNotFoundException;
import employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        Employee employee =employeeRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Employee with ID = " + id + " doesn't exist."));
        employeeRepository.delete(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by ID=" + id + " was not found."));
    }
}
