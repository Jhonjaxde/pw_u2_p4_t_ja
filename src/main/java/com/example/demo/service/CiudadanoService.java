package com.example.demo.service;


import com.example.demo.repository.modelo.Ciudadano;

public interface CiudadanoService {
	
	public void guardar(Ciudadano cuidadano);
	public void actualizar(Ciudadano cuidadano);
	public void borrar(String cedula);
	public Ciudadano buscar(String cedula);


}