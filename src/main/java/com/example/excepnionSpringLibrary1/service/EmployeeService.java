package com.example.excepnionSpringLibrary1.service;

import com.example.excepnionSpringLibrary1.exception.EmployeeAlreadyAddedException;
import com.example.excepnionSpringLibrary1.exception.EmployeeNotFoundException;
import com.example.excepnionSpringLibrary1.exception.EmployeeStoragelsFullException;
import com.example.excepnionSpringLibrary1.exception.IncorrectlyWrittenException;
import com.example.excepnionSpringLibrary1.model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {

    private static final int SIZE_LIMIT = 10; // константа мах колл чел.
    private final Map<String, Employee> employees = new HashMap<>(SIZE_LIMIT);

    public EmployeeService() {
        Employee employee1 = new Employee("Ivan", "Ivanov", 1, 10000);
        Employee employee2 = new Employee("Oleg", "Olegov", 1, 20000);
        Employee employee3 = new Employee("Nastya", "Novikova", 2, 15000);
        Employee employee4 = new Employee("Alex", "Fedorov", 2, 25000);
        employees.put(createKey(employee1), employee1);
        employees.put(createKey(employee2), employee2);
        employees.put(createKey(employee3), employee3);
        employees.put(createKey(employee4), employee4);

    }

    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Employee add(Employee employee) { // добавим сотр.
        if (!StringUtils.isAlpha(employee.getFirstName())
                || !StringUtils.isAlpha(employee.getLastName()))
            throw new IncorrectlyWrittenException();
        if (employees.size() >= SIZE_LIMIT) {
            throw new EmployeeStoragelsFullException();
        }

        if (employees.containsKey(createKey(employee))) {     // добавляем метод который нам выдаст ключ
            throw new EmployeeAlreadyAddedException();                // если такой ключ есть , то выкидыв исключение
        }
        wordWithBig(employee);                                //после всех проверок добавляем вызов нашего метода, он поправит наш регистр.
        employees.put(createKey(employee), employee); // если его нет, то кладем ключ
        return employee; // вернем сотрудника который пришел.
    }

    public Employee remove(String firstName, String lastName) {

        return employees.remove(createKey(firstName, lastName));
    }

    public Employee find(String firstName, String lastName) {

        Employee employee = employees.get(createKey(firstName, lastName));
        if (employee == null) {
            throw new EmployeeNotFoundException();

        }
        return employee;
    }

    private static void wordWithBig(Employee employee) { // метод который позволяет сделать так, чтобы слово
        // начиналось с большой буквы
        employee.setFirstName(StringUtils.capitalize(employee.getFirstName().toLowerCase()));
        employee.setLastName(StringUtils.capitalize(employee.getLastName().toLowerCase()));
    }

    // public List<Employee> getAll() {
    //    return Collections.unmodifiableList(new ArrayList<>(employees.values()));
    // }

    private static String createKey(Employee employee) {

        return createKey(employee.getFirstName(), employee.getLastName());

    }

    private static String createKey(String firstName, String lastName) {

        return (firstName + lastName).toLowerCase(); // приводим к нижнему регистру

    }

}







