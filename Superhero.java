package model;

public class Superhero {
	private int id;
	private String name;
	private String alias;
	private String gender;
	private int age;
	private String powers;
	private String team;

	public Superhero(int id, String name, String alias, String gender, int age, String powers, String team) {
		this.id = id;
		this.name = name;
		this.alias = alias;
		this.gender = gender;
		this.age = age;
		this.powers = powers;
		this.team = team;
	}

	// Getters and Setters...

	public Superhero() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPowers() {
		return powers;
	}

	public void setPowers(String powers) {
		this.powers = powers;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Superhero{" + "id=" + id + ", name='" + name + '\'' + ", alias='" + alias + '\'' + ", gender='" + gender
				+ '\'' + ", age=" + age + ", powers='" + powers + '\'' + ", team='" + team + '\'' + '}';
	}
}
