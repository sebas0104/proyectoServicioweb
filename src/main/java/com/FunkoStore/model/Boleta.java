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
@Table(name = "tb_boleta")
public class Boleta implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nro_bol")
	Long nro_bol;

	@Column(name = "cod_per")
	String cod_per;

	@Column(name = "cod_cli")
	String cod_cli;

	@Column(name = "cod_tip_pag")
	String cod_tip_pag;

	@Column(name = "total")
	double total;

	@Column(name = "fecha_reg")
	String fecha_reg;

}
