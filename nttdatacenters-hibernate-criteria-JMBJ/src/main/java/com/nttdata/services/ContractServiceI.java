package com.nttdata.services;

import java.util.List;

import com.nttdata.persitence.Contract;

public interface ContractServiceI {

	Contract searchForId(int id);

	List<Contract> getAllContracts();

	void insertContract(Contract entity);

	void updateContract(Contract entity);

	void deleteContract(Contract entity);

	List<Contract> searchForIdClient(Long idClient);
}
