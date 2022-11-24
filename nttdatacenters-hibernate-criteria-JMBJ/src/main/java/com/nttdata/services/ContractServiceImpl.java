package com.nttdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.dao.ContractDaoI;
import com.nttdata.persitence.Contract;

@Service
public class ContractServiceImpl implements ContractServiceI{

	@Autowired
	private ContractDaoI conctractDao;

	/**
	 * Buscar contrato por id
	 * @param id
	 * @return
	 */
	public Contract searchForId(int id) {
		return conctractDao.findById(id);
	}

	/**
	 * Recuperar todos los contratos
	 * @return
	 */
	public List<Contract> getAllContracts() {
		return conctractDao.findAll();
	}

	/**
	 * Insertar Contrato
	 * @param entity
	 */
	public void insertContract(Contract entity) {
		conctractDao.create(entity);
	}

	/**
	 * Actualizar Contrato
	 * @param entity
	 */
	public void updateContract(Contract entity) {
		conctractDao.update(entity);
	}

	/**
	 * Borrar Contrato
	 * @param entity
	 */
	public void deleteContract(Contract entity) {
		conctractDao.delete(entity);
	}

	/**
	 * Buscar por id Cliente
	 * @param idClient
	 * @return
	 */
	public List<Contract> searchForIdClient(Long idClient) {

		return conctractDao.searchByContractByClientId(idClient);
	}

}
