package com.nttdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.dao.ClienteDaoI;
import com.nttdata.persitence.Cliente;

@Service
public class ClienteServiceImpl implements ClienteServiceI {

	@Autowired
	private ClienteDaoI clienteDao;

	public Cliente buscarClientePorId(int id) {
		return clienteDao.findById(id);
	}

	@Override
	public List<Cliente> buscarClientePorNombreYApellido(String nombre, String apellido) {
		return clienteDao.findByNameAndLastName(nombre, apellido);
	}

	@Override
	public Cliente borrarCliente(Cliente entity) {
		clienteDao.delete(entity);
		return null;

	}

	@Override
	public Cliente actualizar(Cliente entity) {
		return clienteDao.update(entity);
	}

	@Override
	public List<Cliente> obtenerClientes() {

		return clienteDao.findAll();
	}

	@Override
	public void agregarCliente(Cliente entity) {
		clienteDao.create(entity);
	}

	@Override
	public List<Cliente> buscarClienteCriteriaPorNombreYApellido(String name, String lastName) {

		return clienteDao.buscarClienteCriteriaPorNombreYApellido(name, lastName);
	}




}
