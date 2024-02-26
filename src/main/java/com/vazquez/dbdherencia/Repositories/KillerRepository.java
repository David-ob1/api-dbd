package com.vazquez.dbdherencia.Repositories;

import com.vazquez.dbdherencia.Models.subclass.Killer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KillerRepository extends JpaRepository<Killer,String> {


    boolean existsByName(String name);

}
