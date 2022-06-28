package com.FunkoStore.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "tb_cliente")
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_cli")
	Long cod_cli;
	
	@Column(name="nom_cli")
	String nom_cli;
	
	@Column(name="ape_cli")
	String ape_cli;
	
	@Column(name="fec_nac_cli")
	Date fec_nac_cli;
	
	@Column(name="email_cli")
	String email_cli;
	
	@Column(name="dni_cli")
	String dni_cli;
	
	@Column(name="tel_cli")
	String tel_cli;
	
	@Column(name="dir_cli")
	String dir_cli;
	
	@Column(name="distrito")
	String distrito;
	
}
