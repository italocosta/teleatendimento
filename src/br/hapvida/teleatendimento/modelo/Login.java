package br.hapvida.teleatendimento.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import br.hapvida.teleatendimento.dao.ConnectionFactory;

public class Login {
	
	private Long cd_login;
	private String nm_operador;
	private String fl_disponivel;
	private Calendar dt_logou;
	private Calendar dt_deslogou;

	
	
	public Long getCd_login() {
		return cd_login;
	}
	public void setCd_login(Long cd_login) {
		this.cd_login = cd_login;
	}
	public String getNm_operador() {
		return nm_operador;
	}
	public void setNm_operador(String nm_operador) {
		this.nm_operador = nm_operador;
	}
	public String getFl_disponivel() {
		return fl_disponivel;
	}
	public void setFl_disponivel(String fl_disponivel) {
		this.fl_disponivel = fl_disponivel;
	}
	public Calendar getDt_logou() {
		return dt_logou;
	}
	public void setDt_logou(Calendar dt_logou) {
		this.dt_logou = dt_logou;
	}
	public Calendar getDt_deslogou() {
		return dt_deslogou;
	}
	public void setDt_deslogou(Calendar dt_deslogou) {
		this.dt_deslogou = dt_deslogou;
	}

	
	


	

}
