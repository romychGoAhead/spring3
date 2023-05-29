package com.example.excepnionspring3.service;

import com.example.excepnionspring3.exception.EmployeeAlreadyAddedException;
import com.example.excepnionspring3.exception.EmployeeNotFoundException;
import com.example.excepnionspring3.exception.EmployeeStoragelsFullException;
import com.example.excepnionspring3.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private final Map<String, Employee> employees = new HashMap();
    private static final int MAX_SIZE = 5; // константа мах колл чел.

    public Employee add(String firstName, String lastName) { // добавим сотр.
        if (employees.size() >= MAX_SIZE) {
            throw new EmployeeStoragelsFullException();
        }
        Employee employeeToAdd = new Employee(firstName, lastName);
        if (employees.containsKey(createKey(firstName, lastName))) {     // добавляем метод который нам выдаст ключ
            throw new EmployeeAlreadyAddedException();                // если такой ключ есть , то выкидыв исключение
        }

        employees.put(createKey(firstName, lastName), employeeToAdd); // если его нет, то кладем ключ
        return employeeToAdd; // вернем сотрудника который пришел.
    }

    public Employee remove(String firstName, String lastName) {
        Employee employeeToRemove = new Employee(firstName, lastName);
        if (!employees.containsKey(createKey(firstName, lastName))) {   // проверка ключа если такой ключ есть
            throw new EmployeeNotFoundException();
        }

        return employees.remove(createKey(firstName, lastName)); //то удаляем сотрудника по ключу, метод вернет то что он удалил
    }

    public Employee find(String firstName, String lastName) {

        if (!employees.containsKey(createKey(firstName, firstName))) { //если у нас нет сотрудника то выкид исключение
            throw new EmployeeNotFoundException();
            // в противном случае возвращаем сотрудника
        }
        return employees.get(createKey(firstName, lastName));
    }

    public List<Employee> getAll() {
        return Collections.unmodifiableList(new ArrayList<>(employees.values()));
    }

    // добавляем метод который выдает ключ
    private String createKey(String firstName, String lastName) {

        return (firstName + lastName).toLowerCase(); // приводим к нижнему регистру


    }
}







