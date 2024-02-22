package com.vazquez.dbdherencia.Repositories;

import com.vazquez.dbdherencia.Models.subclass.Killer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KillerRepositories extends JpaRepository<Killer,String> {
}
