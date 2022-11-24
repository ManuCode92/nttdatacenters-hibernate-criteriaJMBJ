package com.nttdata.persitence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * Clase Cliente
 * 
 * @author jmbj
 *
 */
@Entity
@Table(name = "Cliente")
public class Cliente extends AbstractEntity implements Serializable {

	/** Serial version */
	private static final long serialVersionUID = 1L;

	/**
	 * Identificador unico
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_client")
	private Long id;

	/**
	 * Nombre del cliente
	 */

	@Column(name = "name")
	private String nombre;

	/**
	 * Primer apellido cliente
	 */

	@Column(name = "first_last_name")
	private String primerApellido;

	/**
	 * Segundo apellido cliente
	 */

	@Column(name = "second_last_name")
	private String segundoApellido;

	/**
	 * Número de documento de indentidad (único, no nulo y hasta 9 caracteres).
	 */
	@Column(name = "document_id", unique = true, nullable = false, length = 9)
	private String documentoIdentidad;

	// Getters y Setters
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getDocumentoIdentidad() {
		return documentoIdentidad;
	}

	public void setDocumentoIdentidad(String documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", primerApellido=" + primerApellido + ", segundoApellido="
				+ segundoApellido + ", documentoIdentidad=" + documentoIdentidad + "]";
	}


}
