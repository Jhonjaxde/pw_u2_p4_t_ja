package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.dto.EstudianteDTO;

public interface EstudianteRepository {
	
	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public Estudiante buscar(Integer id	);
	public void eliminar(Integer id);
	public Estudiante seleccionarPorApellido(String apellido);
	public Estudiante seleccionarPorApellidoTyped(String apellido);
	public List<Estudiante> seleccionarListaApellido(String apellido);
	public Estudiante seleccionarPorApellidoyNombre(String apellido, String nombre);
	public List<EstudianteDTO> seleccionarTodosDTO();
	public List<EstudianteDTO> seleccionarTodosDTOConCedula();
}