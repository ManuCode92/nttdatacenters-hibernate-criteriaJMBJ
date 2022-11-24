package com.nttdata.dao;

import java.util.List;

import com.nttdata.persitence.Cliente;

/**
 * Interfaz DAO de la tabla Client
 * 
 * @author jmbj
 *
 */
public interface ClienteDaoI extends CommonDaoI<Cliente> {

	/**
	 * Se obtiene los clientes por el nombre y apellido
	 * 
	 * @param name
	 * @param lastName
	 * @return List<Client>
	 */
	List<Cliente> findByNameAndLastName(String name, String lastName);

	List<Cliente> buscarClienteCriteriaPorNombreYApellido(String name, String lastName);
}
