package com.vazquez.dbdherencia.Controllers;

import com.vazquez.dbdherencia.DTO.NewKiller;
import com.vazquez.dbdherencia.DTO.NewPerson;
import com.vazquez.dbdherencia.Models.Person;
import com.vazquez.dbdherencia.Models.subclass.Killer;
import com.vazquez.dbdherencia.Repositories.KillerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/killers")
public class KillerController {

    @Autowired
    private KillerRepository killerRepository;




    @PostMapping("")
    public ResponseEntity<String> addKiller(@RequestBody NewKiller newKiller){
    //validation




    Killer killer = new Killer(newKiller.name(),newKiller.perk(),newKiller.power(),newKiller.speed());
    killerRepository.save(killer);

    return new ResponseEntity<>("Se agrego nuevo killer",HttpStatus.CREATED);


    }



    @GetMapping("")
    public List<Killer> getAll(){return killerRepository.findAll();}

}
