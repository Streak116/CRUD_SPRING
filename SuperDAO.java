package dao;

import java.util.List;

import model.Superhero;

public interface SuperDAO {
	Superhero fetchFirst();

	void addRecord(Superhero superhero);

	void deleteRecord(Superhero superhero);

	List<Superhero> fetchAllRecords();

	void editRecord(Superhero superhero);

}
