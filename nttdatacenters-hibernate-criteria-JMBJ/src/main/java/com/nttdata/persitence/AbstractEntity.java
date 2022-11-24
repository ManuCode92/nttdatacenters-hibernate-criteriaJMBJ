package com.nttdata.persitence;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**
 * 
 * @author jmbj
 *
 */

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/**Serial version*/
	private static final long serialVersionUID = 1L;
	/**
	 * Devuelve un valor entero
	 * @return in
	 */
	public abstract Long getId();
	/**
	 * Para modificar el id
	 * @param id
	 */
	public abstract void setId(Long id);
	
}
