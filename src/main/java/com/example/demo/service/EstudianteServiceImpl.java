package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.Query;

import com.example.demo.repository.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	
	@Autowired
	private EstudianteRepository estudianteRepo;
	
	@Override
	public void agregar(Estudiante estudiante) {
	this.estudianteRepo.insertar(estudiante);
		
	}

	@Override
	public void modificar(Estudiante estudiante) {
	this.estudianteRepo.actualizar(estudiante);	
		
	}

	@Override
	public Estudiante encontrar(Integer id) {
	
		return this.estudianteRepo.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.estudianteRepo.eliminar(id);
		
	}

	@Override
	public Estudiante encontrarPorApellido(String apellido) {
		return this.estudianteRepo.seleccionarPorApellido(apellido);
	}

	@Override
	public List<Estudiante> encontrarListaPorApellido(String apellido) {
		return this.estudianteRepo.seleccionarListaApellido(apellido);
	}

	@Override
	public Estudiante encontrarPorApellidoyNombre(String apellido, String nombre) {
		return this.estudianteRepo.seleccionarPorApellidoyNombre(apellido, nombre);
	}

	@Override
	public Estudiante encontrarPorApellidoTyped(String apellido) {
		return this.estudianteRepo.seleccionarPorApellidoTyped(apellido);
	}

}