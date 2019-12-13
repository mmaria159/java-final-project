package lab5.macoveim.controller;

import lab5.macoveim.model.Employee;
import lab5.macoveim.model.Organisation;
import lab5.macoveim.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public void save(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable long id) {
        return employeeRepository.findById(id);
    }

    @DeleteMapping("/{employeeId}")
    public void delete(@PathVariable long employeeId) {
        employeeRepository.delete(employeeId);
    }

    @PutMapping
    public void update(@RequestBody Employee employee) { employeeRepository.update(employee);
    }

}

