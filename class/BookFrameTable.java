package com.example.library;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BookFrameTable extends JFrame {
	public BookFrameTable() {
		super("Cadastrar livros");
		BookDAO _bookDAO = new BookDAO();
		BookTableModel _tableModel = new BookTableModel(_bookDAO);
		JTable _table = new JTable(_tableModel);
		JScrollPane _scroll = new JScrollPane();
		_scroll.setViewportView(_table);
		add(_scroll);
		JButton _btAdd = new JButton("Adicionar");
		
		_btAdd.addActionListener((event) -> {
			JTextField fieldTitle = new JTextField();
	        JTextField fieldAuthor = new JTextField();
	        JTextField fieldType = new JTextField();
	        JTextField fieldYear = new JTextField();
	        
	        JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Título"));
            panel.add(fieldTitle);
            panel.add(new JLabel("Autor"));
            panel.add(fieldAuthor);
            panel.add(new JLabel("Tipo"));
            panel.add(fieldType);
            panel.add(new JLabel("Ano"));
            panel.add(fieldYear);
            
            int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Livros",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
            	_tableModel.addBook(fieldTitle.getText(), fieldAuthor.getText(), fieldType.getText(), fieldYear.getText());
            	panel.setVisible(false);
            } else if (result == JOptionPane.CANCEL_OPTION) {
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Deseja Realmente fechar a aplicação?",
                        "Sair - Confirmação",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) {
                	panel.setVisible(false);
                }
            } else {
            	panel.setVisible(false);
            }
			
		});
		add(_btAdd, BorderLayout.SOUTH);
		setSize(600, 300);
	}
}
