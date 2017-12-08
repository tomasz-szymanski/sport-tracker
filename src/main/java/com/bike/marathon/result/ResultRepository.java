package com.bike.marathon.result;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ResultRepository extends CrudRepository<Result, Long> {
	List<Result> findAll();
}
