package com.nttdata;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.persitence.Cliente;
import com.nttdata.persitence.Contract;
import com.nttdata.services.ClienteServiceI;
import com.nttdata.services.ContractServiceI;

/**
 * Formación - Hibernate - Ejemplo
 * 
 * Clase principal
 * 
 * @author jmbj
 *
 */
@SpringBootApplication
public class NTTDataMain implements CommandLineRunner {

	@Autowired
	private ClienteServiceI clienteService;

	@Autowired
	private ContractServiceI contratoService;

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NTTDataMain.class, args);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run(String... args) throws Exception {

		System.out.println("Creando Cliente");
		// Cliente 1
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Jose Manuel");
		cliente1.setPrimerApellido("Becerra");
		cliente1.setSegundoApellido("Justiniano");
		cliente1.setDocumentoIdentidad("12345678M");

		// Cliente 2
		Cliente cliente2 = new Cliente();
		cliente2.setNombre("Patrick");
		cliente2.setPrimerApellido("Aguilera");
		cliente2.setSegundoApellido("Duran");
		cliente2.setDocumentoIdentidad("87654321N");

		// Agregar cliente service
		clienteService.agregarCliente(cliente1);
		clienteService.agregarCliente(cliente2);

		List<Cliente> clientsList = clienteService.obtenerClientes();
		System.out.println("Mostrando cliente");
		for (Cliente cliente : clientsList) {
			System.out.println(cliente);
		}

		System.out.println("Actualizando cliente");
		cliente1.setDocumentoIdentidad("11111111A");
		clienteService.actualizar(cliente1);

		System.out.println("Mostrando cliente despues de actualizar");
		clientsList = clienteService.obtenerClientes();
		for (Cliente cliente : clientsList) {
			System.out.println(cliente);
		}
		System.out.println("Buscando cliente");

		List<Cliente> clienteSearch = clienteService.buscarClientePorNombreYApellido("Patrick", "Aguilera");
		int total = clienteSearch.size();
		System.out.println("Se ha encontrado " + total + " clientes con ese nombre.");
	
		System.out.println("Creando contractos");
		
		Contract contrato1 = new Contract();
		contrato1.setCaducityDate(new Date("13/07/2022"));
		contrato1.setValiditDate(new Date("31/07/2022"));
		contrato1.setMonthlyPrice(13.00);
		contrato1.setId(cliente1.getId());
		Contract contrato2 = new Contract();
		contrato2.setCaducityDate(new Date("13/08/2022"));
		contrato2.setValiditDate(new Date("31/08/2022"));
		contrato2.setMonthlyPrice(9.50);
		contrato2.setId(cliente2.getId());


		contratoService.insertContract(contrato1);
		contratoService.insertContract(contrato2);
		
		System.out.println("Mostrando contratos ");
		
		List<Contract> contratosList = contratoService.getAllContracts();
		for (Contract contract : contratosList) {
			System.out.println(contract);
		}
						
		System.out.println("Busqueda de (Criteria)");
		
		List<Cliente> criteriaBusqueda = clienteService.buscarClienteCriteriaPorNombreYApellido("Jose Manuel", "Becerra");
		
		for (Cliente cliente : criteriaBusqueda) {
			System.out.println(cliente.toString());
		}
		
		System.out.println("F I N    D E L    P R O G R A M A");
		
	
	}

}
