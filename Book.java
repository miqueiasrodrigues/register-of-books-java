/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.library;

/**
 *
 * @author Miqueias
 */
class Book {
	private String id;
	private String title;
	private String author;
	private String type;
	private String year;

	public void setId(String _id) {
		this.id = _id;
	}
	
	public void setTitle(String _title) {
		this.title = _title;
	}

	public void setAuthor(String _author) {
		this.author = _author;
	}

	public void setType(String _type) {
		this.type = _type;
	}

	public void setYear(String _year) {
		this.year = _year;
	}
	
	public String getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return this.author;
	}

	public String getType() {
		return this.type;
	}

	public String getYear() {
		return this.year;
	}

	public String getBooks() {
		return "Livros [Id:"+ this.id + "Titulo: " + this.title + "Autor: " + this.author 
				+ "Tipo: " + this.type + "Ano: " + this.year + "]";
	}
}
