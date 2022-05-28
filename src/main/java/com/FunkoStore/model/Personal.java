package com.FunkoStore.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data 
@Table(name = "tb_personal")
public class Personal {
	@Id
	@Column(name = "cod_per")
	private int idpersonal;
	
	@Column(name = "nom_per")
	private String nombreper;
	
	@Column(name = "ape_per")
	private String apellidoper;
	
	@Column(name = "fec_nac_per")
	private String fechaper;
	
	@Column(name = "email_per")
	private String emailper;
	
	@Column(name = "dni_per")
	private int dniper;
	
	@Column(name = "tel_per")
	private String telefonoper;
	
	@Column(name = "dir_per")
	private String direccionper;
	
	@Column(name = "cod_rol")
	private String idrol;

	public int getIdpersonal() {
		return idpersonal;
	}

	public void setIdpersonal(int idpersonal) {
		this.idpersonal = idpersonal;
	}

	public String getNombreper() {
		return nombreper;
	}

	public void setNombreper(String nombreper) {
		this.nombreper = nombreper;
	}

	public String getApellidoper() {
		return apellidoper;
	}

	public void setApellidoper(String apellidoper) {
		this.apellidoper = apellidoper;
	}

	public String getFechaper() {
		return fechaper;
	}

	public void setFechaper(String fechaper) {
		this.fechaper = fechaper;
	}

	public String getEmailper() {
		return emailper;
	}

	public void setEmailper(String emailper) {
		this.emailper = emailper;
	}

	public int getDniper() {
		return dniper;
	}

	public void setDniper(int dniper) {
		this.dniper = dniper;
	}

	public String getTelefonoper() {
		return telefonoper;
	}

	public void setTelefonoper(String telefonoper) {
		this.telefonoper = telefonoper;
	}

	public String getDireccionper() {
		return direccionper;
	}

	public void setDireccionper(String direccionper) {
		this.direccionper = direccionper;
	}

	public String getIdrol() {
		return idrol;
	}

	public void setIdrol(String idrol) {
		this.idrol = idrol;
	}

	@Override
	public String toString() {
		return "Personal [idpersonal=" + idpersonal + ", nombreper=" + nombreper + ", apellidoper=" + apellidoper
				+ ", fechaper=" + fechaper + ", emailper=" + emailper + ", dniper=" + dniper + ", telefonoper="
				+ telefonoper + ", direccionper=" + direccionper + ", idrol=" + idrol + "]";
	}
	
	
	
	
	
	}
