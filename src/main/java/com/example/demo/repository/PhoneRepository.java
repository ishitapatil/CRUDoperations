package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

	Phone save(Phone p);
}
