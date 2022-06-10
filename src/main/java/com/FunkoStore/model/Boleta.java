package com.FunkoStore.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_boleta")
public class Boleta implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nro_bol")
	int nro_bol;
	
	@Column(name="cod_per")
	String cod_per;

	@Column(name="cod_cli")
	String cod_cli;
	
	@Column(name="cod_tip_pag")
	String cod_tip_pag;
	
	@Column(name="total")
	Double total;
	
	@Column(name="fecha_reg")
	Date fecha_reg;
	
}
