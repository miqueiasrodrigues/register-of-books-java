package com.example.library;

/**
*
* @author Miqueias
*/

public class Library {
	public static void main(String[] args) {
		BookDAO bookDAO = new BookDAO();
		Book book = new Book();		
		
		/*Criando o banco de dados e a tabela*/
		bookDAO.createDatabase();
		bookDAO.createTable();
		
		BookFrameTable frame = new BookFrameTable();
		frame.setVisible(true);
	}
}
