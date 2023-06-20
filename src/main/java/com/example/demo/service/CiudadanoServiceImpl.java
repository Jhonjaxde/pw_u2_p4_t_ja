package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CiudadanoRepository;

import com.example.demo.repository.modelo.Ciudadano;

@Service
public class CiudadanoServiceImpl implements CiudadanoService {

	@Autowired
	private CiudadanoRepository ciudadanoRepository;
	@Override
	public void guardar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.insertar(ciudadano);
		
	}

	@Override
	public void actualizar(Ciudadano cuidadano) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.actualizar(cuidadano);
	}

	@Override
	public void borrar(String cedula) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.eliminar(cedula);
	}

	@Override
	public Ciudadano buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.buscar(cedula);
	}

}