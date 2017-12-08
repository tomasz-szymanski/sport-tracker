package com.bike.marathon.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByFirstName(String firstName);

	List<User> findByLastName(String lastName);

	List<User> findByCity(String city);

	List<User> findByCountry(String country);

	List<User> findByStartNumber(Long startNumber);

}
