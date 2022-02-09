/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Miqueias
 */

public class BookDAO {
	/*
	 * Adicionar url, usuário e senha do banco de dados
	 */
	private static final String DB_URL = "";
	private static final String USER = "";
	private static final String PASS = "";

	/*
	 * Criação do banco de dados do sistema
	 */
	public void createDatabase() {
		String sql = "CREATE DATABASE IF NOT EXISTS LIBRARY;";
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
			stmt.close();
			conn.close();
			System.out.println("Database created successfully...");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * Criação da tabela do sistema
	 */
	public void createTable() {
		String sql = "CREATE TABLE IF NOT EXISTS BOOK("
				+ "ID INT UNSIGNED NOT NULL AUTO_INCREMENT KEY,"
				+ "TITLE varchar(128),"
				+ "AUTHOR varchar(128),"
				+ "TYPE varchar(64),"
				+ "YEAR CHAR(4));";
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.execute("USE LIBRARY;");
			stmt.execute();
			stmt.close();
			System.out.println("Table created successfully...");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * Inserir dados no banco de dados do sistema
	 */

	public void insertInDatabase(Book _book) {
		String sql = "INSERT INTO BOOK("
				+ "TITLE, AUTHOR, TYPE, YEAR) VALUES(?,?,?,?)";
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setString(1, _book.getTitle());
			stmt.setString(2, _book.getAuthor());
			stmt.setString(3, _book.getType());
			stmt.setString(4, _book.getYear());
			stmt.execute("USE LIBRARY;");
			stmt.execute();
			stmt.close();
			System.out.print("Data entered successfully...");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * recuperar dados no banco de dados do sistema
	 */

	public List<Book> selectInDatabase() {
		List<Book> _books = new LinkedList<Book>();
		String sql = "SELECT * FROM BOOK";
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.execute("USE LIBRARY;");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Book _book = new Book();
				_book.setId(rs.getString("id"));
				_book.setTitle(rs.getString("title"));
				_book.setAuthor(rs.getString("author"));
				_book.setType(rs.getString("type"));
				_book.setYear(rs.getString("year"));
				_books.add(_book);
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return _books;
	}
	
	public void updateInDatabase(Book _book) {
		String sql = "UPDATE BOOK SET TITLE=?, AUTHOR=?, TYPE=?, YEAR=? WHERE ID =?";
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setString(1, _book.getTitle());
			stmt.setString(2, _book.getAuthor());
			stmt.setString(3, _book.getType());
			stmt.setString(4, _book.getYear());
			stmt.setString(5, _book.getId());
			stmt.execute("USE LIBRARY;");
			stmt.execute();
			stmt.close();
			System.out.print("Data updated successfully...");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
