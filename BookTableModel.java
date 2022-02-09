package com.example.library;

import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class BookTableModel extends AbstractTableModel implements TableModelListener{

	BookDAO bookDAO;
	List<Book> books;
	List<String> bookColumn;

	public BookTableModel(BookDAO _bookDAO) {
		this.bookDAO = _bookDAO;
		books = _bookDAO.selectInDatabase();
		bookColumn = List.of("Id" ,"Título", "Autor", "Tipo", "Ano");
		this.addTableModelListener(this);
	}

	@Override
	public int getRowCount() {
		return books.size();
	}

	@Override
	public int getColumnCount() {
		return bookColumn.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Book _book = books.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return _book.getId();
		case 1:
			return _book.getTitle();
		case 2:
			return _book.getAuthor();
		case 3:
			return _book.getType();
		case 4:
			return _book.getYear();
		}
		return null;
	}

	@Override
	public String getColumnName(int Column) {
		return bookColumn.get(Column);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex != 0;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Book _book = books.get(rowIndex);
		switch (columnIndex) {
		case 0:
			_book.setId(aValue.toString());
			break;
		case 1:
			_book.setTitle(aValue.toString());
			break;
		case 2:
			_book.setAuthor(aValue.toString());
			break;
		case 3:
			_book.setType(aValue.toString());
			break;
		case 4:
			_book.setYear(aValue.toString());
			break;
		}
		fireTableCellUpdated(rowIndex, columnIndex);

	}

	@Override
	public void tableChanged(TableModelEvent e) {
		int i = e.getFirstRow();
		Book _book = books.get(i);
		bookDAO.updateInDatabase(_book);	
	}
	
	public void addBook(String _title, String _author, String _type, String _year) {
		Book _book = new Book();
		_book.setTitle(_title);
		_book.setAuthor(_author);
		_book.setType(_type);
		_book.setYear(_year);
		books.add(_book);
		bookDAO.insertInDatabase(_book);
		fireTableDataChanged();
	}
	
}
