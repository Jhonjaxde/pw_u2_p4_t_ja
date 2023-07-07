package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Videojuego;

import aj.org.objectweb.asm.Type;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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
		// SQL
		// SELECT * FROM videojuego e WHERE e.vdjo_nombre=
		// JPQL
		// SELECT e FROM Videojuego e WHERE e.nombre =
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Videojuego e WHERE e.nombre =:datoNombre ");
		myQuery.setParameter("datoNombre", nombre);
		return (Videojuego) myQuery.getSingleResult();
	}

	@Override
	public Videojuego seleccionarPorNombreTyped(String nombre) {
		TypedQuery<Videojuego> myQuery = this.entityManager
				.createQuery("SELECT e FROM Videojuego e WHERE e.nombre =:datoNombre ", Videojuego.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Videojuego> seleccionarListaNombre(String nombre) {
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Videojuego e WHERE e.nombre =:datoNombre ");
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getResultList();
	}

	@Override
	public Videojuego seleccionarPorNombreYPlataforma(String nombre, String plataforma) {
		Query myQuery = this.entityManager
				.createQuery("SELECT e FROM Videojuego e WHERE e.nombre =:datoNombre AND e.plataforma=:datoPlataforma");
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoPlataforma", plataforma);
		return (Videojuego) myQuery.getSingleResult();
	}

	@Override
	public List<Videojuego> seleccionarListaNombreTyped(String nombre) {
		TypedQuery<Videojuego> myQuery = this.entityManager
				.createQuery("SELECT e FROM Videojuego e WHERE e.nombre =:datoNombre ", Videojuego.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getResultList();
	}

	@Override
	public List<Videojuego> seleccionarDinamicoVideojuego(String nombre, String plataforma, BigDecimal costo) {

		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Videojuego> myQuery = myBuilder.createQuery(Videojuego.class);

		Root<Videojuego> miTablaFrom = myQuery.from(Videojuego.class);

		// si es mayor costo del videojuego < 60 e.nombre= AND e.plataforma
		// <= 100 e.nombre= or e.plataforma=?

		Predicate pNombre = myBuilder.equal(miTablaFrom.get("nombre"), nombre);
		Predicate pPlataforma = myBuilder.equal(miTablaFrom.get("plataforma"), plataforma);

		Predicate predicadoFinal = null;
		if (costo.compareTo(BigDecimal.valueOf(60)) >= 0) {
			predicadoFinal = myBuilder.or(pNombre, pPlataforma);
		} else {
			predicadoFinal = myBuilder.and(pNombre, pPlataforma);
		}
		// 4. Armamos mi SQL final
		myQuery.select(miTablaFrom).where(predicadoFinal);
		TypedQuery<Videojuego> myQueryFinal = this.entityManager.createQuery(myQuery);

		return myQueryFinal.getResultList();
	}

	@Override
	public int eliminarPorNombre(String nombre) {
		// String jpql="DELETE FROM Videojuego e WHERE e.nombre=:datoNombre";

		Query myQuery = this.entityManager.createQuery("DELETE FROM Videojuego e WHERE e.nombre=:datoNombre");
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.executeUpdate();
	}

	@Override
	public int actualizarPorPlataforma(String nombre, String plataforma) {
		// String jpql="UPDATE Videojuego e SET e.nombre=:datoNombre WHERE e.plataforma=:datoPlataforma";

		Query myQuery = this.entityManager
				.createQuery("UPDATE Videojuego e SET e.nombre=:datoNombre WHERE e.plataforma=:datoPlataforma");
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoPlataforma", plataforma);

		return myQuery.executeUpdate();
	}

}
