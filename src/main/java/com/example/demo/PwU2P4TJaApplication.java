package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
//import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Ciudadano;

import com.example.demo.repository.modelo.Empleado;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.repository.modelo.Autor;
import com.example.demo.repository.modelo.Libro;
import com.example.demo.service.AutorService;
import com.example.demo.service.CiudadanoService;
import com.example.demo.service.EmpleadoService;
import com.example.demo.service.HabitacionService;
import com.example.demo.service.HotelService;
import com.example.demo.service.LibroService;


//import com.example.demo.service.EmpleadoService;



@SpringBootApplication
public class PwU2P4TJaApplication implements CommandLineRunner {
	
	@Autowired
	private CiudadanoService ciudadanoService;
	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private HotelService hotelService; 
	@Autowired
	private AutorService autorService;
	@Autowired
	private LibroService libroService;
	
	

	

	public static void main(String[] args) {
		SpringApplication.run(PwU2P4TJaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
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
		*/
		/*Hotel hot = new Hotel();
		hot.setDireccion("av.carapungo");
		hot.setNombre("cinco estrellas");
		

		Habitacion hab = new Habitacion();
		
		hab.setNumero("68");
		hab.setValor(new BigDecimal(78));
		
		List<Habitacion>habitaciones= new ArrayList<>();
		habitaciones.add(hab);
		hot.setHabitaciones(habitaciones);
		
		this.hotelService.eliminar("1");*/
		Set<Autor> autores=new HashSet<>();
		 
		
		Autor aut = new Autor();
		aut.setNombre("Juan");
		aut.setApellido("Cortez");
		
		Autor aut1 = new Autor();
		aut1.setNombre("Juan");
		aut1.setApellido("Artegon");
		
		autores.add(aut);
		autores.add(aut1);
		
		Set<Libro> libros= new HashSet<>();
		
		Libro lib=new Libro();
		lib.setTitulo("El principito");
		lib.setEditorial("Santillana");
	
		libros.add(lib);
	
		lib.setAutores(autores);//aqui por esta cascade en autor
		
		this.autorService.eliminar("1");
		
		
		
	

		

		
		
	
	}

}


