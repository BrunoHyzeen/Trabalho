package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acao.Acao;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioLoja extends JFrame {

	private JPanel contentPane;
	private JTextField txtpesquisa;
	private JTable table;

	public FormularioLoja() {
		Acao a = new Acao();
		setResizable(false);
		setTitle("Loja");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 10, 450, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtpesquisa = new JTextField();
		txtpesquisa.setBounds(10, 11, 417, 26);
		contentPane.add(txtpesquisa);
		txtpesquisa.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 417, 203);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JComboBox combo_departamentos = new JComboBox();
		combo_departamentos.setBounds(10, 48, 210, 22);
		contentPane.add(combo_departamentos);
		combo_departamentos.addItem("Compre por departamento");
		combo_departamentos.addItem("Celulares");
		combo_departamentos.addItem("Automotivos");

		// AÇÃO DO BOTÃO CARRINHO DE COMPRAS
		JButton btncarrinhodecompras = new JButton("Carrinho");
		btncarrinhodecompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FormularioCarrinhodeCompras().setVisible(true);

			}
		});
		btncarrinhodecompras.setIcon(new ImageIcon(
				"C:\\Users\\Bruno\\Desktop\\Trabalho de Loja\\Trabalho 21-05\\src\\formularios\\batata.PNG"));
		btncarrinhodecompras.setBounds(328, 48, 99, 22);
		contentPane.add(btncarrinhodecompras);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				table.setModel(a.selecionar());

			}
		});
		btnAtualizar.setBounds(20, 73, 89, 23);
		contentPane.add(btnAtualizar);
		
		//AÇÃO DO BOTÃO DE LOGIN
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new FormularioLogin().setVisible(true);
			}
		});
		btnLogin.setBounds(338, 73, 89, 23);
		contentPane.add(btnLogin);
	}
}
