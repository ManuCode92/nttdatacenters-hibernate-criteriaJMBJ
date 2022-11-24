package com.nttdata.services;

import java.util.List;

import com.nttdata.persitence.Cliente;

/**
 * Interfaz Servicio Cliente
 * @author jmbj
 *
 */

public interface ClienteServiceI {
	
	/**
	 * Recuper
	 * @param id
	 * @return
	 */
	Cliente buscarClientePorId(int id);
	List<Cliente> buscarClientePorNombreYApellido(String name, String lastName);
	public Cliente borrarCliente(Cliente entity);
	Cliente actualizar(Cliente entity);
	List<Cliente> obtenerClientes();
	public void agregarCliente(Cliente entity);
	List<Cliente> buscarClienteCriteriaPorNombreYApellido(String name, String lastName);
}
