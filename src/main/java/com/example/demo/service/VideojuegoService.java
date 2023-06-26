package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Videojuego;

public interface VideojuegoService {
	public void agregar(Videojuego juego);
	public Videojuego encontrar(Integer id);
	public void modificar(Videojuego juego);
	public void borrar(Integer id);
	public Videojuego encontrarPorNombre(String nombre);
	public Videojuego encontrarPorNombreTyped(String nombre);
	public List<Videojuego> encontrarListaPorNombre(String nombre);
	public Videojuego encontrarPorNombreYPlataforma(String nombre, String plataforma);
	public List<Videojuego> encontrarListaPorNombreTyped(String nombre);
}
