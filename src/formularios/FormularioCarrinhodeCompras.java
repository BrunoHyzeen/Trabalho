package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acao.Acao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioCarrinhodeCompras extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static int codigoProdutos;

	public FormularioCarrinhodeCompras() {
		Acao a = new Acao();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblItensAdicionados = new JLabel("Itens Adicionados");
		lblItensAdicionados.setBounds(10, 11, 115, 14);
		contentPane.add(lblItensAdicionados);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 29, 469, 195);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnFinalizarCompra = new JButton("Finalizar compra");
		btnFinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				JOptionPane.showMessageDialog(null,
						"Obrigado por comprar, as informações da compra será enviada para o seu e-mail");
			}

		});
		btnFinalizarCompra.setBounds(10, 271, 152, 23);
		contentPane.add(btnFinalizarCompra);

		// AÇÃO DO BOTÃO CANCELAR
		JButton btnCancelarCompra = new JButton("Cancelar Compra");
		btnCancelarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});
		btnCancelarCompra.setBounds(172, 271, 141, 23);
		contentPane.add(btnCancelarCompra);

		// AÇÃO DO BOTAO REMOVER DO CARRINHO
		JButton btnRemoverDoCarrinho = new JButton("Remover do carrinho");
		btnRemoverDoCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				a.excluir(codigoProdutos);
				// ATUALIZAR A LISTA
				table.setModel(a.selecionar());
			}
		});
		btnRemoverDoCarrinho.setBounds(323, 271, 156, 23);
		contentPane.add(btnRemoverDoCarrinho);

		JLabel lblTotal = new JLabel("Total: ");
		lblTotal.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblTotal.setBounds(322, 235, 56, 23);
		contentPane.add(lblTotal);

		// AÇÃO DO BOTÃO ATUALIZAR
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(a.selecionar());
			}
		});
		btnAtualizar.setBounds(20, 235, 89, 23);
		contentPane.add(btnAtualizar);
	}
}
