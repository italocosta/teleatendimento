package br.hapvida.teleatendimento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import br.hapvida.teleatendimento.modelo.Login;

public class LoginDAO {
	private Connection connection;
	
	
	public LoginDAO(Connection con){
		this.connection = con;
	};
	
	public void getLogar(Login l){
		try {
			String sql1 = "select sq_login_atd_virtual.nextval from dual";
			
			PreparedStatement ps = this.connection.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery(sql1);
			rs.next();
			Long cd = rs.getLong(1);
			l.setCd_login(cd);
			
			
			String sql2 = "insert into tb_login_atd_virtual1 (cd_login,nm_operador,fl_disponivel,dt_logou)"
						+ "   values(?,?,?,?)	";
		
		
			ps = this.connection.prepareStatement(sql2);
			ps.setLong(1, cd);
			ps.setString(2,l.getNm_operador().toUpperCase());
			ps.setString(3, l.getFl_disponivel());
			ps.setTimestamp(4, new Timestamp(l.getDt_logou().getTimeInMillis()));
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getDeslogar(Long cod){
		String sql = "update tb_login_atd_virtual1 set dt_deslogou = sysdate, fl_disponivel = 'N' where cd_login = ?";
		PreparedStatement ps;
		try {
			ps = this.connection.prepareStatement(sql);
			ps.setLong(1, cod);
			ps.execute();
			ps.close();
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
