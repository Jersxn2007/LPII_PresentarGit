package org.cibertec.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="tb_proveedor")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idproveedor")
	private int idProveedor;

	@Column(name="nombre_rs")
	private String nombreRs;

	private String telefono;
	private String email;
	
	@Override
	public String toString() {
	    return idProveedor + " - " + nombreRs;
	}
}