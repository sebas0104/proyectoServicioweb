package com.FunkoStore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_categoria")
public class categoria {
	
	@Id
	@Column(name = "cod_cat")
	private String idcategoria;
	
	@Column(name = "nom_cat")
	private String nombrecate;
	
	@Column(name = "desc_cat")
	private String descripcion;

	public String getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(String idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getNombrecate() {
		return nombrecate;
	}

	public void setNombrecate(String nombrecate) {
		this.nombrecate = nombrecate;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "categoria [idcategoria=" + idcategoria + ", nombrecate=" + nombrecate + ", descripcion=" + descripcion
				+ "]";
	}
	
	
	
	
}
