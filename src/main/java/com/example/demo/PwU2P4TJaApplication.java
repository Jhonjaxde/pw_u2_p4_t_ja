package com.example.demo;

import java.math.BigDecimal;
//import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Ciudadano;

import com.example.demo.repository.modelo.Empleado;
import com.example.demo.service.CiudadanoService;


//import com.example.demo.service.EmpleadoService;



@SpringBootApplication
public class PwU2P4TJaApplication implements CommandLineRunner {
	
	@Autowired
	private CiudadanoService ciudadanoService;
	
	
	

	

	public static void main(String[] args) {
		SpringApplication.run(PwU2P4TJaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Ciudadano ciu= new Ciudadano();
		ciu.setApellido("Estrada");
		ciu.setCedula("1745892596");
		ciu.setNombre("jhonatan");
		
		Empleado empleado = new Empleado();
		empleado.setCiudadano(ciu);
		empleado.setCargo("Gerente");
		empleado.setSueldo(new BigDecimal(1500));
		ciu.setEmpleado(empleado);
		
		ciu.setApellido("ojala");
		this.ciudadanoService.borrar("1745892596");
		
	
		
		
	

		

		
		
	
	}

}


