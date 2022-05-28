package com.FunkoStore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "tb_producto")
@Data 
public class producto {
    @Id
    @Column(name = "cod_prod")
	private String  idproducto;
    
    @Column(name = "nom_prod")
	private String nombrepro;
    
    @Column(name = "desc_prod")
	private String descripcionpro;
    
    @Column(name = "cod_cat")
	private int idcategoria;
    
    @Column(name = "stock")
	private int stockpro;
	
    @Column(name = "precio")
	private double preciopro;

	public String getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombrepro() {
		return nombrepro;
	}

	public void setNombrepro(String nombrepro) {
		this.nombrepro = nombrepro;
	}

	public String getDescripcionpro() {
		return descripcionpro;
	}

	public void setDescripcionpro(String descripcionpro) {
		this.descripcionpro = descripcionpro;
	}

	public int getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public int getStockpro() {
		return stockpro;
	}

	public void setStockpro(int stockpro) {
		this.stockpro = stockpro;
	}

	public double getPreciopro() {
		return preciopro;
	}

	public void setPreciopro(double preciopro) {
		this.preciopro = preciopro;
	}

	@Override
	public String toString() {
		return "producto [idproducto=" + idproducto + ", nombrepro=" + nombrepro + ", descripcionpro=" + descripcionpro
				+ ", idcategoria=" + idcategoria + ", stockpro=" + stockpro + ", preciopro=" + preciopro + "]";
	}
	
	
	

}
