package com.vazquez.dbdherencia.Controllers;

import com.vazquez.dbdherencia.DTO.NewSurvivor;
import com.vazquez.dbdherencia.Models.subclass.Survivor;
import com.vazquez.dbdherencia.Repositories.SurvivorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/survivor")
public class SurvivorController {
@Autowired
    private SurvivorRepository survivorRepository;


@PostMapping("/add")
public ResponseEntity<String> addSurvivor (@RequestBody NewSurvivor newSurvivor){

    boolean nameEmpty = newSurvivor.name().isBlank();
    boolean perkIsEmpty = newSurvivor.perk1().isBlank();


    if(nameEmpty || perkIsEmpty){
        StringBuilder response = new StringBuilder();

        response.append(nameEmpty ? "the name is empty" :"");
        response.append(perkIsEmpty ? "the perk is void" : "");


        return new ResponseEntity<>(response.toString(), HttpStatus.FORBIDDEN);
    }

    if(survivorRepository.existsByName(newSurvivor.name())){
        return new ResponseEntity<>("the killer survivor exist",HttpStatus.FORBIDDEN);
    }


    Survivor survivor = new Survivor(newSurvivor.name(),newSurvivor.perk1(), newSurvivor.perk2(), newSurvivor.perk3());
    survivorRepository.save(survivor);

    return new ResponseEntity<>("Se agrego el nuevo survivor", HttpStatus.CREATED);
}

@GetMapping("/all")

    public List<Survivor> getAll(){return survivorRepository.findAll();}

}
