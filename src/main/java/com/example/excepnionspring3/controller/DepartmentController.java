package com.example.excepnionspring3.controller;

import com.example.excepnionspring3.model.Employee;
import com.example.excepnionspring3.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee detEmployeeWithMaxSalary(@RequestParam("departmentID") int department) {
        return departmentService.detEmployeeWithMaxSalary(department);
    }

    @GetMapping("/min-salary")
    public Employee detEmployeeWithMinSalary(@RequestParam("departmentID") int department) {
        return departmentService.detEmployeeWithMinSalary(department);
    }

    @GetMapping("/all")
    private Map<Integer, List<Employee>> getAll() {
        return departmentService.getAll();
    }
}
