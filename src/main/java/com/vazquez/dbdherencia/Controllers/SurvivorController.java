package com.vazquez.dbdherencia.Controllers;

import com.vazquez.dbdherencia.Models.subclass.Survivor;
import com.vazquez.dbdherencia.Repositories.SurvivorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/survivor")
public class SurvivorController {
@Autowired
    private SurvivorRepository survivorRepository;



@GetMapping("/all")
    public List<Survivor> getAll(){return survivorRepository.findAll();}

}
