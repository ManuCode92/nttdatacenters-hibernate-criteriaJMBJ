package com.nttdata.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.nttdata.persitence.Cliente;
import com.nttdata.persitence.Contract;

/**
 * Implementa DAO de la tabla Client
 * 
 * @author jmbj
 *
 */
@Repository
public class ClienteDaoImpl extends CommonDaoImpl<Cliente> implements ClienteDaoI {
	/** Manejador de entidades */
	@Autowired
	private EntityManager entityManager;

	
	@Override
	public List<Cliente> findByNameAndLastName(String name, String lastName) {

		// Obtención de sesión
		Session currentSession = entityManager.unwrap(Session.class);

		// Busqueda de todos los registros
		@SuppressWarnings("unchecked")
		List<Cliente> clientes = currentSession.createQuery("FROM Cliente WHERE nombre = '" + name + "' and "
				+ "(primerApellido = '" + lastName + "' or segundoApellido = '" + lastName + "')").list();

		currentSession.close();

		return clientes;
	}

	
	
	@Override
	@Transactional
	public List<Cliente> buscarClienteCriteriaPorNombreYApellido(String name, String lastName) {
		// CriteriaBuilder
		CriteriaBuilder cbuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Cliente> cqcquery = cbuilder.createQuery(Cliente.class);
		Root<Cliente> root = cqcquery.from(Cliente.class);
		//condición
		Predicate predicate1 = cbuilder.equal(root.get("nombre"), name);
		Predicate predicate2 = cbuilder.equal(root.get("primerApellido"), lastName);
		Predicate predicate3 = cbuilder.equal(root.get("segundoApellido"), lastName);
		cqcquery.select(root).where(cbuilder.and(predicate1, predicate2, predicate3));
		//Ejecucion de la consulta
		return entityManager.createQuery(cqcquery).getResultList();
	}



	@Override
	public Cliente searchById(Long idClient) {
		Session currentSession = entityManager.unwrap(Session.class);

		// Busqueda de cliente por id.
		Cliente client = (Cliente) currentSession.createQuery("FROM Cliente WHERE Cliente.id_client = " + idClient);

		currentSession.close();

		return client;
	}

}
