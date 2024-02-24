package com.vazquez.dbdherencia;

import com.vazquez.dbdherencia.Models.subclass.Killer;
import com.vazquez.dbdherencia.Models.subclass.Survivor;
import com.vazquez.dbdherencia.Repositories.KillerRepositories;
import com.vazquez.dbdherencia.Repositories.SurvivorRepositories;
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
	public CommandLineRunner initData(KillerRepositories killerRepositories,
									  SurvivorRepositories survivorRepositories									  ){

		return args ->{



			Killer trapper = new Killer("Trampero", "Presencia Perturbadora" ,"trampa para osos", 4.6);
			killerRepositories.save(trapper);

			Killer deathslinger = new Killer("Deathslinger" , "Interruptor del Hombre Muerto", "Aprehensor", 4.4);
			killerRepositories.save(deathslinger);

			Killer nemesis = new Killer("Nemesis","Acecho Letal", "Virus T",4.6);
			killerRepositories.save(nemesis);


			Survivor dwight = new Survivor("Dwight", "Vínculo");
			survivorRepositories.save(dwight);

			Survivor david = new Survivor("David", "Chungo");
			survivorRepositories.save(david);

			Survivor nea = new Survivor("Nea"," Caída Equilibrada");
			survivorRepositories.save(nea);
		};
	}
}
