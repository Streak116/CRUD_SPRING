package bLogic;

import java.util.List;

import dao.SuperDAO;
import model.Superhero;

public class Fetch {
	// @Autowired
	public static Superhero fetch(SuperDAO shd) {
		System.out.println("In fetch");
		// CRUDDAO cd = new CRUDDaoImpl();
		Superhero s = shd.fetchFirst();

		return s;

	}

	// @Autowired
	public static void add(Superhero s, SuperDAO shd) {
		System.out.println("In Fetch add");
		System.out.println("In fetch");
		// CRUDDAO cd = new CRUDDaoImpl();
		shd.addRecord(s);

	}

	// @Autowired
	public static void delete(Superhero s, SuperDAO shd) {
		System.out.println("In Fetch delete");
		System.out.println("In fetch");
		// CRUDDAO cd = new CRUDDaoImpl();
		shd.deleteRecord(s);

	}

	// @Autowired
	public static List<Superhero> fetchAllRecords(SuperDAO shd) {
		List<Superhero> s;
		// CRUDDAO cd = new CRUDDaoImpl();
		s = shd.fetchAllRecords();
		return s;
	}

	// @Autowired
	public static void edit(Superhero s, SuperDAO shd) {
		System.out.println("In Fetch add");
		System.out.println("In fetch");
		// CRUDDAO cd = new CRUDDaoImpl();
		shd.editRecord(s);

	}

}
