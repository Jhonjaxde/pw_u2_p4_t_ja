package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Videojuego;

public interface VideojuegoRepository {
	
	public void insertar(Videojuego juego);
	public void actualizar(Videojuego juego);
	public Videojuego buscar(Integer id);
	void eliminar(Integer id);
	public Videojuego seleccionarPorNombre(String nombre);
	public Videojuego seleccionarPorNombreTyped(String nombre);
	public List<Videojuego> seleccionarListaNombre(String nombre);
	public Videojuego seleccionarPorNombreYPlataforma(String nombre,String plataforma);
	public List<Videojuego> seleccionarListaNombreTyped(String nombre);
	public List<Videojuego> seleccionarDinamicoVideojuego(String nombre,String plataforma,BigDecimal costo);
	
	

}
