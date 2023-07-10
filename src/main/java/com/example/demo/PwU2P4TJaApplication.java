package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.modelo.Alumno;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.Videojuego;
import com.example.demo.service.EstudianteService;
import com.example.demo.service.HabitacionService;
import com.example.demo.service.HotelService;
import com.example.demo.service.MatriculaService;
import com.example.demo.service.VideojuegoService;




//import com.example.demo.service.EmpleadoService;



@SpringBootApplication
public class PwU2P4TJaApplication implements CommandLineRunner {
	
	
	@Autowired
	private VideojuegoService service;
	
	@Autowired
	private EstudianteService estudianteService;
	@Autowired
	private MatriculaService matriculaService;
	
	@Autowired
	private HotelService hotelService;	
	
	@Autowired
	private HabitacionService habitacionService;
	@Autowired
	private HotelRepository hotelRepository;

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
		
		Videojuego juego5 = new Videojuego();
		juego5.setNombre("GTA 5");
		juego5.setPlataforma("PC,PS, XBOX");
		juego5.setCosto(new BigDecimal(20));
		
	

		List<Videojuego> juegos = new ArrayList<>();
		juegos.add(juego1);
		juegos.add(juego2);
		juegos.add(juego3);
		juegos.add(juego4);
		juegos.add(juego5);
		
		/*for(Videojuego vj:juegos) {
			System.out.println("nombre: "+ vj.getNombre() +" para "+vj.getPlataforma() +" tiene un valor de: " + vj.getCosto());
		}
		*/
		
		Materia mat = new Materia();
		mat.setNombre("orientacion sexual");
		
		
		Alumno alu = new Alumno();
		alu.setNombre("Jhonzote");
		
				
		Matricula matri = new Matricula();
		matri.setFecha(LocalDateTime.now());
		matri.setNumero("65");
		matri.setAlumno(alu);
		matri.setMateria(mat);
		//this.matriculaService.agregar(matri);
				
		//this.habitacionService.eliminar(2);
		Habitacion hab = new Habitacion();
		hab.setNumero("78");
		hab.setValor(new BigDecimal(988));
		
		
		Habitacion hab1 = new Habitacion();
		hab1.setNumero("13");
		hab1.setValor(new BigDecimal(918));
		
		
		List<Habitacion> habitaciones = new ArrayList<>();
		habitaciones.add(hab);
		habitaciones.add(hab1);
		
		Hotel ho = new Hotel();
		ho.setNombre("cincoestrellitas");
		ho.setDireccion("av.carapungo");
		ho.setHabitaciones(habitaciones);
		hab.setHotel(ho);
		hab1.setHotel(ho);
		//this.hotelService.guardar(ho);
		
		/*System.out.println(this.hotelService.buscar(4).getNombre());
		
		for(Habitacion h: this.hotelService.buscar(4).getHabitaciones()) {
			System.out.println(h.getNumero());
		}*/
		
		//this.hotelRepository.buscar(4).getHabitaciones().size();
		//hotelRepository.buscar(4).getHabitaciones().size();
		//System.out.println("cantidad de habitaciones: "+ho.getHabitaciones().size());
		System.out.println(this.estudianteService.encontrarTodosDTO());
		
		System.out.println(this.estudianteService.encontrarTodosDTOConCedula());
		//System.out.println(this.estudianteService.encontrar(7).getCedula());
		
	}

}


