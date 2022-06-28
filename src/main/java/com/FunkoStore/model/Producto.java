package com.FunkoStore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_producto")
public class Producto implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_prod")
	Long cod_prod;

	@Column(name = "nom_prod")
	String nom_prod;

	@Column(name = "desc_prod")
	String desc_prod;

	@Column(name = "cod_cat")
	String cod_cat;

	@Column(name = "stock")
	Long stock;

	@Column(name = "precio")
	double precio;
}
