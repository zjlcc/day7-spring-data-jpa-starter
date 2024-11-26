package com.oocl.springbootemployee.service;

import com.oocl.springbootemployee.exception.EmployeeAgeNotValidException;
import com.oocl.springbootemployee.exception.EmployeeAgeSalaryNotMatchedException;
import com.oocl.springbootemployee.model.Employee;
import com.oocl.springbootemployee.model.Gender;
import com.oocl.springbootemployee.repository.EmployeeMemoryRepository;
import com.oocl.springbootemployee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {
    @Mock
    EmployeeMemoryRepository mockedEmployeeMemoryRepository;

    @Mock
    EmployeeRepository mockedEmployeeRepository;

    private void build() {
        mockedEmployeeMemoryRepository = mock(EmployeeMemoryRepository.class);
        mockedEmployeeRepository = mock(EmployeeRepository.class);
    }

    @Test
    void should_return_the_given_employees_when_getAllEmployees() {
        //given
        build();
        when(mockedEmployeeRepository.findAll()).thenReturn(List.of(new Employee(1, "Lucy", 18, Gender.FEMALE, 8000.0)));
        EmployeeService employeeService = new EmployeeService(mockedEmployeeMemoryRepository,mockedEmployeeRepository);

        //when
        List<Employee> allEmployees = employeeService.findAll();

        //then
        assertEquals(1, allEmployees.size());
        assertEquals("Lucy", allEmployees.get(0).getName());
    }

    @Test
    void should_return_the_created_employee_when_create_given_a_employee() {
        //given
        build();
        Employee lucy = new Employee(1, "Lucy", 18, Gender.FEMALE, 8000.0);
        when(mockedEmployeeRepository.save(any())).thenReturn(lucy);
        EmployeeService employeeService = new EmployeeService(mockedEmployeeMemoryRepository, mockedEmployeeRepository);

        //when
        Employee createdEmployee = employeeService.create(lucy);

        //then
        assertEquals("Lucy", createdEmployee.getName());
    }

    @Test
    void should_throw_EmployeeAgeNotValidException_when_create_given_a_employee_with_age_17() {
        //given
        build();
        Employee kitty = new Employee(1, "Kitty", 6, Gender.FEMALE, 8000.0);
        EmployeeService employeeService = new EmployeeService(mockedEmployeeMemoryRepository,mockedEmployeeRepository);
        //when
        //then
        assertThrows(EmployeeAgeNotValidException.class, () -> employeeService.create(kitty));
        verify(mockedEmployeeRepository, never()).save(any());
    }

    @Test
    void should_throw_EmployeeAgeNotValidException_when_create_given_a_employee_with_age_66() {
        //given
        EmployeeMemoryRepository mockedEmployeeMemoryRepository = mock(EmployeeMemoryRepository.class);
        Employee kitty = new Employee(1, "Kitty", 66, Gender.FEMALE, 8000.0);
        EmployeeService employeeService = new EmployeeService(mockedEmployeeMemoryRepository, mockedEmployeeRepository);
        //when
        //then
        assertThrows(EmployeeAgeNotValidException.class, () -> employeeService.create(kitty));
        verify(mockedEmployeeMemoryRepository, never()).create(any());
    }

    @Test
    void should_created_employee_active_when_create_employee() {
        //given
        build();
        EmployeeService employeeService = new EmployeeService(mockedEmployeeMemoryRepository, mockedEmployeeRepository);
        Employee lucy = new Employee(1, "Lucy", 18, Gender.FEMALE, 8000.0);
        //when
        employeeService.create(lucy);
        /* then */
        verify(mockedEmployeeRepository).save(argThat(Employee::getActive));
    }

//    @Test
//    void should_throw_EmployeeAgeSalaryNotMatchedException_when_save_given_a_employee_with_age_over_30_and_salary_below_20K() {
//        //given
//        EmployeeMemoryRepository mockedEmployeeMemoryRepository = mock(EmployeeMemoryRepository.class);
//        Employee bob = new Employee(1, "Bob", 31, Gender.FEMALE, 8000.0);
//        EmployeeService employeeService = new EmployeeService(mockedEmployeeMemoryRepository);
//        //when
//        //then
//        assertThrows(EmployeeAgeSalaryNotMatchedException.class, () -> employeeService.create(bob));
//        verify(mockedEmployeeMemoryRepository, never()).create(any());
//    }
//
//    @Test
//    void should_throw_EmployeeInactiveException_when_update_inactive_employee() {
//        //given
//        EmployeeMemoryRepository mockedEmployeeMemoryRepository = mock(EmployeeMemoryRepository.class);
//        Employee inactiveEmployee = new Employee(1, "Bob", 31, Gender.FEMALE, 8000.0);
//        inactiveEmployee.setActive(false);
//        when(mockedEmployeeMemoryRepository.findById(1)).thenReturn(inactiveEmployee);
//        EmployeeService employeeService = new EmployeeService(mockedEmployeeMemoryRepository);
//        //when
//        //then
//        assertThrows(EmployeeInactiveException.class, () -> employeeService.update(1, inactiveEmployee));
//        verify(mockedEmployeeMemoryRepository, never()).create(any());
//    }
}
