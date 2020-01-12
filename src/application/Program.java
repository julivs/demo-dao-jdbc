package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import db.DbException;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		SellerDao sellerDao = DaoFactory.createSellerDao();

		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n\n=== Result 2: Find by department ===\n");

		List<Seller> list = sellerDao.finByDepartment(new Department(1, null));

		list.forEach(System.out::println);

		System.out.println("\n\n=== Result 3: Find all ===\n");

		list = sellerDao.findAll();

		list.forEach(System.out::println);
		
		
		System.out.println("\n\n=== Result 4: Insert ===\n");
		
		Seller seller2 = new Seller();
		seller2.setName("Juliano Schmitt");
		try {
			seller2.setBirthDate(new Date(sdf.parse("15/11/1975").getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		seller2.setEmail("julivs@gmail.com");
		seller2.setDepartment(new Department(3, null));
		seller2.setBaseSalary(3000.0);
		
		sellerDao.insert(seller2);
		
		if (seller2.getId() != null) {
			System.out.println("Success. Id: " + seller2.getId());
		}
		else {
			throw new DbException ("Error including seller.");
		}
		
		
		System.out.println("\n\n=== Result 5: Update seller ===\n");
		
		seller = sellerDao.findById(7);
		seller.setBaseSalary(3500.0);
		
		sellerDao.update(seller);
		
		list = sellerDao.findAll();
		list.forEach(System.out::println);
		
System.out.println("\n\n=== Result 6: Delete seller ===\n");
		
		sellerDao.deleteById(7);
		
		list = sellerDao.findAll();
		list.forEach(System.out::println);
	}

}
