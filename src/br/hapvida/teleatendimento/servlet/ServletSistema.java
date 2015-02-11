package br.hapvida.teleatendimento.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.hapvida.teleatendimento.dao.LoginDAO;
import br.hapvida.teleatendimento.modelo.Login;

@WebServlet("/sistema")
public class ServletSistema extends HttpServlet{
	
	LoginDAO dao;
	
	protected void service(HttpServletRequest req,
			               HttpServletResponse res)
				throws ServletException, IOException{
		
		String operacao = req.getParameter("operacao");		
		PrintWriter pw = res.getWriter();
		
		if(operacao != null){
			if( operacao.equals("logar")){
				try{
					String user = req.getParameter("login");
					Connection conn = (Connection)req.getAttribute("conexao");
					Login login = new Login();
					dao = new LoginDAO(conn);
					login.setNm_operador(user);
					login.setFl_disponivel("S");
					login.setDt_logou(Calendar.getInstance());
					dao.getLogar(login);			
					
					req.setAttribute("cod",login.getCd_login());
					RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
					rd.forward(req, res);			
				}catch(Exception e){
					pw.println("Usuário e/ou senha inválido !");
					//pw.println(user+" - "+senha);
					throw new RuntimeException(e.getMessage());
					
				}
			}
			if( operacao.equals("deslogar")){
				String ret = req.getParameter("cod");
				long cod = Long.parseLong(ret);
				dao.getDeslogar(cod);
				
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.forward(req, res);
			}
		}else{
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.forward(req, res);	
		}
		
	}
}
