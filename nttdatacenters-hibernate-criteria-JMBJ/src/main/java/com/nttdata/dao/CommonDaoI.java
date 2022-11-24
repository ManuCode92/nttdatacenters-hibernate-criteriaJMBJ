package com.nttdata.dao;

import java.util.List;


/**
 * 
 * @author jmbj
 * 
 *         DAO Taller practico 1 apartado 2
 *
 * @param <T>
 */

public interface CommonDaoI<T> {

	/**
	 * Buscar por id
	 * @param id
	 * @return
	 */
	T findById(int id);	
	
	/**
	 * Inserta un registro
	 * 
	 * @param entity
	 */
	void create(T entity);

	/**
	 * Búsqueda de todos los registros
	 * 
	 * @return List<AllClient>
	 */
	List<T> findAll();

	/**
	 * Localiza un registro por ID
	 * 
	 * @param id
	 * @return List<AllClient>
	 */
	T searchById(Long id);

	/**
	 * Elimina un registro en la BBDD
	 * 
	 * @param entity
	 */
	void delete(T entity);

	/**
	 * Actualiza un registro en la BBDD
	 * 
	 * @param entity
	 * @return Devuelve un objeto del registro
	 */

	public T update(T entity);


}
