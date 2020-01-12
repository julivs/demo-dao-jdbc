package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao dd = DaoFactory.createDepartmentDao();
		
		Department dep = dd.findById(3);
		
		System.out.println(dep);
		
		System.out.println("\n\n=== All ===\n");
		
		List<Department> list = dd.findAll();
		
		list.forEach(System.out::println);
		
		System.out.println("\n\n=== Delete ===\n");
		
		dd.deleteById(8);
		
		list = dd.findAll();
		
		list.forEach(System.out::println);
		
		System.out.println("\n\n=== Insert ===\n");
		
		dep.setName("Music");
		
		dd.insert(dep);
		
		System.out.println("Success. Id: " + dep.getId() + "\n\n");
		
		list = dd.findAll();
		
		list.forEach(System.out::println);
		
		System.out.println("\n\n=== Update ===\n");
		
		dep.setName("Guns");
		dep.setId(7);
		
		dd.update(dep);
		
		list = dd.findAll();
		
		list.forEach(System.out::println);

	}

}
