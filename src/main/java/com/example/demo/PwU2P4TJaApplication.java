package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.demo.repository.modelo.Videojuego;

import com.example.demo.service.VideojuegoService;




//import com.example.demo.service.EmpleadoService;



@SpringBootApplication
public class PwU2P4TJaApplication implements CommandLineRunner {
	
	
	@Autowired
	private VideojuegoService service;
	
	

	

	public static void main(String[] args) {
		SpringApplication.run(PwU2P4TJaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		
		Videojuego juego1 = new Videojuego();
		juego1.setNombre("Devil May Cry");
		juego1.setPlataforma("PC, PS, XBOX");
		juego1.setCosto(new BigDecimal(60));
		
		Videojuego juego2 = new Videojuego();
		juego2.setNombre("Resident Evil");
		juego2.setPlataforma("PC, PS, XBOX");
		juego2.setCosto(new BigDecimal(60));
		
		
		Videojuego juego3 = new Videojuego();
		juego3.setNombre("Spider-man miles morales");
		juego3.setPlataforma("PS");
		juego3.setCosto(new BigDecimal(50));
		
		Videojuego juego4 = new Videojuego();
		juego4.setNombre("Spider-man miles morales");
		juego4.setPlataforma("PC");
		juego4.setCosto(new BigDecimal(45));
		//this.service.agregar(juego4);
		
		//this.service.borrar(2);
		/*
		System.out.println(this.service.encontrarPorNombre(juego2.getNombre()));
		System.out.println(this.service.encontrarPorNombreYPlataforma("Spider-man miles morales", "PC"));
		System.out.println(this.service.encontrarPorNombreTyped("Devil May Cry"));
		*/
	

		List<Videojuego> juegos = new ArrayList<>();
		juegos.add(juego1);
		juegos.add(juego2);
		juegos.add(juego3);
		juegos.add(juego4);
		
		for(Videojuego vj:juegos) {
			System.out.println("nombre: "+ vj.getNombre());
		}
		
		System.out.println(this.service.encontrarListaPorNombreTyped("Spider-man miles morales"));
		
		
		
		
	
	}

}


