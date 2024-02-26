package com.vazquez.dbdherencia.Repositories;

import com.vazquez.dbdherencia.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,String> {

    Person findByEmail(String email);



}
