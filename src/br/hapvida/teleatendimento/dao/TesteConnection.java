package br.hapvida.teleatendimento.dao;

public class TesteConnection {

	public static void main(String[] args) {
		try{
			new ConnectionFactory().getConnection("italorrc","italo0");
			System.out.println("Conectou !!!!");
		}catch(Exception e){
			System.out.println("Usu�rio e/ou Senha inv�lido");
		}

	}

}
