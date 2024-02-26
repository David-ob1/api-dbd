package com.vazquez.dbdherencia.Controllers;

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




//    @PostMapping("")
//    public ResponseEntity<String> addKiller(@RequestBody)
//

    @GetMapping("")
    public List<Killer> getAll(){return killerRepository.findAll();}

}
