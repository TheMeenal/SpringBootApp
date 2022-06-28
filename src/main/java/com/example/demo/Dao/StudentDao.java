package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Students;

@Repository
public interface StudentDao extends JpaRepository<Students, Integer> {

	//Students getOne(long studentId);

}
