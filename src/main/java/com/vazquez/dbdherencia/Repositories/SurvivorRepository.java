package com.vazquez.dbdherencia.Repositories;

import com.vazquez.dbdherencia.Models.subclass.Survivor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurvivorRepository extends JpaRepository <Survivor,String> {

    boolean existsByName(String name);

}
