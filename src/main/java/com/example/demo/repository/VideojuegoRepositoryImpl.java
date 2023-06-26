package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Videojuego;

import aj.org.objectweb.asm.Type;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class VideojuegoRepositoryImpl implements VideojuegoRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Videojuego juego) {
		this.entityManager.persist(juego);
		
	}

	@Override
	public void actualizar(Videojuego juego) {
		this.entityManager.merge(juego);
		
	}

	@Override
	public Videojuego buscar(Integer id) {
		
		return this.entityManager.find(Videojuego.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		Videojuego juego = this.buscar(id);
		this.entityManager.remove(juego);
		
	}

	@Override
	public Videojuego seleccionarPorNombre(String nombre) {
		//SQL
		//SELECT * FROM videojuego e WHERE e.vdjo_nombre=
		//JPQL 
		//SELECT e FROM Videojuego e WHERE e.nombre = 
		Query myQuery = this.entityManager.createQuery(
				"SELECT e FROM Videojuego e WHERE e.nombre =:datoNombre ");
		myQuery.setParameter("datoNombre", nombre);
		return (Videojuego)myQuery.getSingleResult();
	}

	@Override
	public Videojuego seleccionarPorNombreTyped(String nombre) {
		TypedQuery<Videojuego> myQuery = this.entityManager.createQuery(
				"SELECT e FROM Videojuego e WHERE e.nombre =:datoNombre ",Videojuego.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Videojuego> seleccionarListaNombre(String nombre) {
		Query myQuery = this.entityManager.createQuery(
				"SELECT e FROM Videojuego e WHERE e.nombre =:datoNombre ");
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getResultList();
	}

	@Override
	public Videojuego seleccionarPorNombreYPlataforma(String nombre, String plataforma) {
		Query myQuery = this.entityManager.createQuery(
				"SELECT e FROM Videojuego e WHERE e.nombre =:datoNombre AND e.plataforma=:datoPlataforma");
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoPlataforma", plataforma);
		return (Videojuego)myQuery.getSingleResult();
	}

	@Override
	public List<Videojuego> seleccionarListaNombreTyped(String nombre) {
		TypedQuery<Videojuego> myQuery = this.entityManager.createQuery(
				"SELECT e FROM Videojuego e WHERE e.nombre =:datoNombre ",Videojuego.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getResultList();
	}

}
