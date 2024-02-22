package com.vazquez.dbdherencia.Repositories;

import com.vazquez.dbdherencia.Models.subclass.Survivor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurvivorRepositories extends JpaRepository <Survivor,String> {
}
