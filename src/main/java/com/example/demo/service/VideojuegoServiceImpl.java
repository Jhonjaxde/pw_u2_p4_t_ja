package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.repository.VideojuegoRepository;
import com.example.demo.repository.modelo.Videojuego;
@Service
public class VideojuegoServiceImpl implements VideojuegoService{
	
	@Autowired
	private VideojuegoRepository videojuegoRepository;
	
	@Override
	public void agregar(Videojuego juego) {
		this.videojuegoRepository.insertar(juego);
		
	}

	@Override
	public Videojuego encontrar(Integer id) {
		
		return this.videojuegoRepository.buscar(id);
	}

	@Override
	public void modificar(Videojuego juego) {
		this.videojuegoRepository.actualizar(juego);
		
	}

	@Override
	public void borrar(Integer id) {
		this.videojuegoRepository.eliminar(id);
		
	}

	@Override
	public Videojuego encontrarPorNombre(String nombre) {
		
		return this.videojuegoRepository.seleccionarPorNombre(nombre);
	}

	@Override
	public Videojuego encontrarPorNombreTyped(String nombre) {
		
		return this.videojuegoRepository.seleccionarPorNombreTyped(nombre);
	}

	@Override
	public List<Videojuego> encontrarListaPorNombre(String nombre) {
		
		return this.videojuegoRepository.seleccionarListaNombre(nombre);
	}

	@Override
	public Videojuego encontrarPorNombreYPlataforma(String nombre, String palataforma) {
		
		return this.videojuegoRepository.seleccionarPorNombreYPlataforma(nombre, palataforma);
	}

	@Override
	public List<Videojuego> encontrarListaPorNombreTyped(String nombre) {
		
		return this.videojuegoRepository.seleccionarListaNombreTyped(nombre);
	}

}
