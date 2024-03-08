package com.vazquez.dbdherencia.Controllers;

import com.vazquez.dbdherencia.DTO.NewKiller;
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

        boolean nameIsEmpty = newKiller.name().isBlank();
        boolean perkIsEmpty = newKiller.perk().isBlank();
        boolean powerIsEmpty = newKiller.power().isBlank();
        boolean speedIsEmpty = newKiller.speed() == 0.0;

        if(nameIsEmpty || perkIsEmpty ||powerIsEmpty ||speedIsEmpty){

            StringBuilder response = new StringBuilder();
            response.append(nameIsEmpty ? "the name is not valid,complete it please." : "");
            response.append(perkIsEmpty ? "the perk is not valid,complete it please." : "" );
            response.append(powerIsEmpty ? "the power es not valid, complete it please." : "");
            response.append(speedIsEmpty ? "complete the speed field" : "");

            return new ResponseEntity<>(response.toString(), HttpStatus.FORBIDDEN);

        }

        if(killerRepository.existsByName(newKiller.name())){
            return new ResponseEntity<>("the killer already exist",HttpStatus.FORBIDDEN);
        }

        Killer killer = new Killer(newKiller.name(),newKiller.perk(),newKiller.power(),newKiller.speed());
        killerRepository.save(killer);

    return new ResponseEntity<>("Se agrego nuevo killer",HttpStatus.CREATED);


    }



    @GetMapping("/all")
    public List<Killer> getAll(){return killerRepository.findAll();}

}
