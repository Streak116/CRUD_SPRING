package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SuperheroMapper implements RowMapper<Superhero> {

	public Superhero mapRow(ResultSet resultSet, int i) throws SQLException {

		Superhero s = new Superhero();
		s.setId(resultSet.getInt("id"));
		s.setName(resultSet.getString("name"));
		s.setAlias(resultSet.getString("alias"));
		s.setGender(resultSet.getString("gender"));
		s.setAge(resultSet.getInt("age"));
		s.setPowers(resultSet.getString("powers"));
		s.setTeam(resultSet.getString("team"));
		return s;
	}
}