package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CompanyEmployeeFacadeTest {

    @Autowired
    private CompanyEmployeeFacade companyEmployeeFacade;

    @MockBean
    private CompanyDao companyDao;

    @MockBean
    private EmployeeDao employeeDao;

    @Test
    void findCompaniesByNameFragment() throws FacadeExceptions {
        // Given
        String nameFragment = "ABC";
        List<Company> companies = Arrays.asList(new Company("ABC Corp"));

        when(companyDao.findCompanyByNameFragment("%" + nameFragment + "%")).thenReturn(companies);

        // When
        List<Company> result = companyEmployeeFacade.findCompaniesByNameFragment(nameFragment);

        // Then
        assertEquals(companies, result);
    }

    @Test
    void findEmployeesByNameFragment() throws FacadeExceptions {
        // Given
        String nameFragment = "John";
        List<Employee> employees = Arrays.asList(new Employee("John", "Doe"));

        when(employeeDao.findEmployeeByNameFragment("%" + nameFragment + "%")).thenReturn(employees);

        // When
        List<Employee> result = companyEmployeeFacade.findEmployeesByNameFragment(nameFragment);

        // Then
        assertEquals(employees, result);
    }
}