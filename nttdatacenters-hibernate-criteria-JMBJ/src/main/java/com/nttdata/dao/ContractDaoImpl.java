package com.nttdata.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nttdata.persitence.Contract;

@Repository
public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<Contract> searchByContractByClientId(Long idClient) {
		// Obtención de sesión
		Session currentSession = entityManager.unwrap(Session.class);

		// Busqueda de todos los registros
		@SuppressWarnings("unchecked")
		List<Contract> contract = currentSession.createQuery("FROM Contract WHERE client.id_client = " + idClient)
				.list();

		currentSession.close();

		return contract;
	}

	@Override
	public Contract searchById(Long id) {

		return null;
	}

}
