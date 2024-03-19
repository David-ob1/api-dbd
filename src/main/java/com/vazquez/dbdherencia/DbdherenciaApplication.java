package com.vazquez.dbdherencia;

import com.vazquez.dbdherencia.Models.Person;
import com.vazquez.dbdherencia.Models.subclass.Killer;
import com.vazquez.dbdherencia.Models.subclass.Survivor;
import com.vazquez.dbdherencia.Repositories.KillerRepository;
import com.vazquez.dbdherencia.Repositories.PersonRepository;
import com.vazquez.dbdherencia.Repositories.SurvivorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DbdherenciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbdherenciaApplication.class, args);
	}


	@Bean
	public CommandLineRunner initData(KillerRepository killerRepository,
									  SurvivorRepository survivorRepository,
									  PersonRepository personRepository){

		return args ->{

			Person vazquez = new Person("David","davidvazquezt2001@gmail.com","david2001");
			personRepository.save(vazquez);

			Killer trapper = new Killer("Trapper",
					"Agitation",
					"Brutal Strength",
					"Unnerving Presence",
					"trampa para osos",4.6,"Tall",32);
			killerRepository.save(trapper);

			Killer deathslinger = new Killer("Deathslinger" ,
					"Dead Man's Switch",
					"Gearhead",
					"Hex: Retribution",
					"Aprehensor",4.4,"Tall",32);
			killerRepository.save(deathslinger);

			Killer nemesis = new Killer("Nemesis",
					"Eruption",
					"Hysteria",
					"Lethal Pursuer",
					"Virus T",4.6,"Tall",32);
			killerRepository.save(nemesis);


			Survivor dwight = new Survivor("Dwight",
					"Bond","Leader","Prove Thyself");
			survivorRepository.save(dwight);

			Survivor david = new Survivor("David",
					"Dead Hard","No Mither","We're Gonna Live Forever");
			survivorRepository.save(david);

			Survivor nea = new Survivor("Nea",
					"Balanced Landing","Streetwise","Urban Evasion");
			survivorRepository.save(nea);
		};
	}
}
