package com.FunkoStore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;



@Entity
@Data
@Table(name = "tb_cliente")
public class Cliente {
	
	@Id
	@Column(name = "cod_cli")
	private int  idcliente;
	
	@Column(name = "nom_cli")
	private String nombrecli;
	
	@Column(name = "ape_cli")
	private String apellidocli;
	
	@Column(name = "fec_nac_cli")
	private String fechacli;
	
	@Column(name = "email_cli")
	private String correocli;
	
	@Column(name = "dni_cli")
	private String dnicli;
	
	@Column(name = "tel_cli")
	private String telefonocli;
	
	@Column(name = "dir_cli")
	private String direccioncli;
	
	@Column(name = "distrito")
	private String distritocli;

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombrecli() {
		return nombrecli;
	}

	public void setNombrecli(String nombrecli) {
		this.nombrecli = nombrecli;
	}

	public String getApellidocli() {
		return apellidocli;
	}

	public void setApellidocli(String apellidocli) {
		this.apellidocli = apellidocli;
	}

	public String getFechacli() {
		return fechacli;
	}

	public void setFechacli(String fechacli) {
		this.fechacli = fechacli;
	}

	public String getCorreocli() {
		return correocli;
	}

	public void setCorreocli(String correocli) {
		this.correocli = correocli;
	}

	public String getDnicli() {
		return dnicli;
	}

	public void setDnicli(String dnicli) {
		this.dnicli = dnicli;
	}

	public String getTelefonocli() {
		return telefonocli;
	}

	public void setTelefonocli(String telefonocli) {
		this.telefonocli = telefonocli;
	}

	public String getDireccioncli() {
		return direccioncli;
	}

	public void setDireccioncli(String direccioncli) {
		this.direccioncli = direccioncli;
	}

	public String getDistritocli() {
		return distritocli;
	}

	public void setDistritocli(String distritocli) {
		this.distritocli = distritocli;
	}

	@Override
	public String toString() {
		return "Cliente [idcliente=" + idcliente + ", nombrecli=" + nombrecli + ", apellidocli=" + apellidocli
				+ ", fechacli=" + fechacli + ", correocli=" + correocli + ", dnicli=" + dnicli + ", telefonocli="
				+ telefonocli + ", direccioncli=" + direccioncli + ", distritocli=" + distritocli + "]";
	}
	
	
	
	
	
}
