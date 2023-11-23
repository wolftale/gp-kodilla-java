package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyEmployeeFacade {

    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    @Autowired
    public CompanyEmployeeFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> findCompaniesByNameFragment(String nameFragment) throws FacadeExceptions {
        try {
            return companyDao.findCompanyByNameFragment("%" + nameFragment + "%");
        } catch (Exception e) {
            throw new FacadeExceptions(FacadeExceptions.ERR_COMPANY_NOT_FOUND);
        }
    }

    public List<Employee> findEmployeesByNameFragment(String nameFragment) throws FacadeExceptions {
        try {
            return employeeDao.findEmployeeByNameFragment("%" + nameFragment + "%");
        } catch (Exception e) {
            throw new FacadeExceptions(FacadeExceptions.ERR_EMPLOYEE_NOT_FOUND);
        }
    }
}
