//package com.kodilla.hibernate.manytomany.dao;
//
//import com.kodilla.hibernate.manytomany.Company;
//import com.kodilla.hibernate.manytomany.Employee;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//
//@SpringBootTest
//public class CompanyDaoTestSuite {
//
//    @Autowired
//    private CompanyDao companyDao;
//
//    @Autowired
//    private EmployeeDao employeeDao;
//
//    @Test
//    void testSaveManyToMany() {
//        //Given
//        Employee johnSmith = new Employee("John", "Smith");
//        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
//        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
//
//        Company softwareMachine = new Company("Software Machine");
//        Company dataMaesters = new Company("Data Maesters");
//        Company greyMatter = new Company("Grey Matter");
//
//        softwareMachine.getEmployees().add(johnSmith);
//        dataMaesters.getEmployees().add(stephanieClarckson);
//        dataMaesters.getEmployees().add(lindaKovalsky);
//        greyMatter.getEmployees().add(johnSmith);
//        greyMatter.getEmployees().add(lindaKovalsky);
//
//        johnSmith.getCompanies().add(softwareMachine);
//        johnSmith.getCompanies().add(greyMatter);
//        stephanieClarckson.getCompanies().add(dataMaesters);
//        lindaKovalsky.getCompanies().add(dataMaesters);
//        lindaKovalsky.getCompanies().add(greyMatter);
//
//        //When
//        companyDao.save(softwareMachine);
//        int softwareMachineId = softwareMachine.getId();
//        companyDao.save(dataMaesters);
//        int dataMaestersId = dataMaesters.getId();
//        companyDao.save(greyMatter);
//        int greyMatterId = greyMatter.getId();
//
//        //Then
//        assertNotEquals(0, softwareMachineId);
//        assertNotEquals(0, dataMaestersId);
//        assertNotEquals(0, greyMatterId);
//
//        //CleanUp
//        try {
//            companyDao.deleteById(softwareMachineId);
//            companyDao.deleteById(dataMaestersId);
//            companyDao.deleteById(greyMatterId);
//        } catch (Exception e) {
//            //do nothing
//
//        }
//    }
//
//    @Test
//     void testFindCompanyByFirstLetters() {
//        //Given
//        Company softwareMachine = new Company("Software Machine");
//        Company dataMaesters = new Company("Data Maesters");
//        Company greyMatter = new Company("Grey Matter");
//
//        companyDao.save(softwareMachine);
//        companyDao.save(dataMaesters);
//        companyDao.save(greyMatter);
//
//        //When
//        List<Company> companiesWithThreeFirstLetters = companyDao.retrieveWithThreeFirstLetters("Sof");
//
//        //Then
//        assertEquals(1, companiesWithThreeFirstLetters.size());
//
//        //CleanUp
//        try {
//            companyDao.deleteAll();
//        } catch (Exception e) {
//            //do nothing
//        }
//    }
//
//    @Test
//    void testFindEmployeeWithLastName() {
//        //Given
//        Employee johnSmith = new Employee("John", "Smith");
//        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
//        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
//
//        employeeDao.save(johnSmith);
//        employeeDao.save(stephanieClarckson);
//        employeeDao.save(lindaKovalsky);
//
//        //When
//        List<Employee> employeesWithLastName = employeeDao.retrieveWithLastname("Smith");
//
//        //Then
//        assertEquals(1, employeesWithLastName.size());
//
//        //CleanUp
//        try {
//            employeeDao.deleteAll();
//        } catch (Exception e) {
//            //do nothing
//        }
//    }
//}
