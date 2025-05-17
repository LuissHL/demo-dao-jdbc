package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("---------find by id-------");
        Department dep = departmentDao.findById(3);
        System.out.println(dep);

        System.out.println("---------find all-------");
        List<Department> list = departmentDao.findAll();
        for(Department sel : list) {
            System.out.println(sel);
        }

        System.out.println("\n=== TEST 4: dep insert =====");
        Department newDep = new Department(null, "Pesca");
        departmentDao.insert(newDep);
        System.out.println("Inserted! New id = " + newDep.getId());

        System.out.println("\n=== TEST 4: update =======");
        Department dep2 = departmentDao.findById(1);
        dep2.setName("Food");
        departmentDao.update(dep2);
        System.out.println("Update completed");

        System.out.println("---------deletebyId-------");
        System.out.println("enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("delete completed");

        sc.close();
    }
}
