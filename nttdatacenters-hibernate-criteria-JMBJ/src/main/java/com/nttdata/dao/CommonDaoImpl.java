package com.nttdata.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nttdata.persitence.AbstractEntity;

import java.lang.reflect.ParameterizedType;

/**
 * DAO GENERICO
 * 
 * @author jmbj
 *
 */
@Repository
public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	/** Tipo de clase */
	private Class<T> entityClass;

	/** Manejador de entidades */
	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public CommonDaoImpl() {
		setEntityClass(
				(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	@Override
	@Transactional
	public T findById(int id) {

		// Obtención de sesión
		Session currentSession = entityManager.unwrap(Session.class);

		// Busqueda por id
		T entity = currentSession.find(entityClass, id);

		// Cierre de sesion
		currentSession.close();
		return entity;
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		// Obtención de sesión
		Session currentSession = entityManager.unwrap(Session.class);

		// Busqueda de todos los registros
		List<T> list = currentSession.createQuery("FROM " + this.entityClass.getName()).list();

		// Cerramos sesión
		currentSession.close();

		return list;

	}

	@Override
	@Transactional
	public void create(T entity) {
		// Obtención de Session
		Session currentSession = entityManager.unwrap(Session.class);

		// Inserccion
		currentSession.save(entity);

		// Cierre de sesion
		currentSession.close();

		// entityManager.persist(entity);
	}

	@Override
	@Transactional
	public T update(T entity) {
		// Obtención de Session
		Session currentSession = entityManager.unwrap(Session.class);

		// Actualizamos
		currentSession.update(entity);

		// Cierre de sesion
		currentSession.close();
		
		return entity;
	}

	@Override
	@Transactional
	public void delete(T entity) {
		// Obtención de Session
		Session currentSession = entityManager.unwrap(Session.class);

		// Borramos
		currentSession.delete(entity);

		// Cierre de sesion
		currentSession.close();

	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
