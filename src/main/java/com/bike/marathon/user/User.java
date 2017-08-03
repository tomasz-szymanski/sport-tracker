package com.bike.marathon.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserSeqGenerator")
	@SequenceGenerator(name = "UserSeqGenerator", sequenceName = "BK.USER_SEQ")
	private Long id;

	private String firstName;

	private String lastName;

	private Long startNumber;

	private String city;

	private String country;

	private String team;

	private String ageGroup;

	public User() {
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", startNumber=" + startNumber +
			", city='" + city + '\'' +
			", country='" + country + '\'' +
			", team='" + team + '\'' +
			", ageGroup='" + ageGroup + '\'' +
			'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getStartNumber() {
		return startNumber;
	}

	public void setStartNumber(Long startNumber) {
		this.startNumber = startNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}
}
