package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

public interface MatriculaService {
	public void agregar(Matricula matricula);
	public void actualizar(Matricula matricula);
	public Matricula encontrar(Integer id);
	public void borrar(Integer id);
	
	public List<MatriculaDTO> reporteMatricula();
}
