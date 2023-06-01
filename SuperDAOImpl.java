package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import model.Superhero;
import model.SuperheroMapper;

public class SuperDAOImpl implements SuperDAO {

	JdbcTemplate jdbcTemplate;

	private final String FIRST = "SELECT * FROM superheroes LIMIT 1";
	private final String INSERT = "INSERT INTO superheroes (name, alias, gender, age, powers, team) VALUES (?, ?, ?, ?, ?, ?)";
	private final String DELETE = "DELETE FROM superheroes WHERE name = ? AND alias = ? AND gender = ? AND age = ? AND powers = ? AND team = ?";
	private final String SELECT_ALL = "SELECT * FROM superheroes order by team";
	private final String UPDATE = "UPDATE superheroes SET name=?, alias=?, gender=?, age=?, powers=?, team=? WHERE id=?";

	@Autowired
	public SuperDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Superhero fetchFirst() {

		return jdbcTemplate.queryForObject(FIRST, new SuperheroMapper());
	}

	@Override
	public void addRecord(Superhero s) {
		jdbcTemplate.update(INSERT, s.getName(), s.getAlias(), s.getGender(), s.getAge(), s.getPowers(), s.getTeam());

	}

	@Override
	public void deleteRecord(Superhero s) {
		jdbcTemplate.update(DELETE, s.getName(), s.getAlias(), s.getGender(), s.getAge(), s.getPowers(), s.getTeam());

	}

	@Override
	public List<Superhero> fetchAllRecords() {
		return jdbcTemplate.query(SELECT_ALL, new SuperheroMapper());
	}

	@Override
	public void editRecord(Superhero s) {
		jdbcTemplate.update(UPDATE, s.getName(), s.getAlias(), s.getGender(), s.getAge(), s.getPowers(), s.getTeam(),
				s.getId());

	}

}
