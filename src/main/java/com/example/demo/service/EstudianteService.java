package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteService {
	
	public void agregar(Estudiante estudiante);
	public void modificar(Estudiante estudiante);
	public Estudiante encontrar(Integer id);
	public void borrar(Integer id);
	public Estudiante encontrarPorApellido(String apellido);
	public Estudiante encontrarPorApellidoTyped(String apellido);
	public List<Estudiante> encontrarListaPorApellido(String apellido);
	public Estudiante encontrarPorApellidoyNombre(String apellido, String nombre);
}