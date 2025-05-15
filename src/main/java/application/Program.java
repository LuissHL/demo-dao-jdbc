package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("---------find by id-------");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("---------find by department-------");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller sel : list) {
            System.out.println(sel);
        }

        System.out.println("---------find all-------");
        list = sellerDao.findAll();
        for(Seller sel : list) {
            System.out.println(sel);
        }

        System.out.println("\n=== TEST 4: seller insert =====");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("---------update-------");
        seller = sellerDao.findById(1);
        seller.setName("Bob bung");
        sellerDao.update(seller);
        System.out.println("Update completed");
    }
}
