package br.hapvida.teleatendimento.filter;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.hapvida.teleatendimento.dao.ConnectionFactory;

@WebFilter("/sistema")
public class FilterSistema implements Filter {

	private Connection connection;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		String operacao = ((HttpServletRequest)req).getParameter("operacao");
		if(operacao != null){
			if( operacao.equals("logar")){
				String user = ((HttpServletRequest)req).getParameter("login");
				String pass = ((HttpServletRequest)req).getParameter("pass");
				try{
					this.connection = new ConnectionFactory().getConnection(user,pass);
					((HttpServletRequest)req).setAttribute("conexao", this.connection);					
				}catch(Exception e){
					System.out.println("Erro login");
				}
			}			
		}
		chain.doFilter(req, res);
		

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
