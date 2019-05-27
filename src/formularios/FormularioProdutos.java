package formularios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acao.Acao;
import beans.Produtos;
import dados.DadosProdutos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class FormularioProdutos extends FormularioLoja {

	private JPanel contentPane;
	private JTextField txtNome_produto;
	private JTextField txtValor_produto;
	private JTable table;
	private static int codigoProdutos;

	private void limparCampos() {
		// LIMPAR OS CAMPOS
		txtNome_produto.setText("");
		txtValor_produto.setText("");
		// FOCUS
		txtNome_produto.requestFocus();
	}

	public FormularioProdutos() {
		setResizable(false);
		// AÇÃO
		Acao a = new Acao();

		setTitle("Cadastro de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 450, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeDoProduto = new JLabel("Nome do Produto");
		lblNomeDoProduto.setBounds(10, 11, 107, 14);
		contentPane.add(lblNomeDoProduto);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(10, 67, 48, 14);
		contentPane.add(lblValor);

		JLabel lblDepartamentos = new JLabel("Departamentos");
		lblDepartamentos.setBounds(210, 11, 107, 14);
		contentPane.add(lblDepartamentos);

		// TEXT FIELD NOME DO PRODUTO
		txtNome_produto = new JTextField();
		txtNome_produto.setBounds(10, 36, 175, 20);
		contentPane.add(txtNome_produto);
		txtNome_produto.setColumns(10);

		// TEXT FIELD VALOR DO PRODUTO
		txtValor_produto = new JTextField();
		txtValor_produto.setBounds(10, 92, 96, 20);
		contentPane.add(txtValor_produto);
		txtValor_produto.setColumns(10);

		// COMBO BOX DEPARTAMENTOS
		JComboBox<String> comboDepartamentos = new JComboBox<String>();
		comboDepartamentos.setBackground(Color.WHITE);
		comboDepartamentos.setBounds(210, 35, 214, 20);
		contentPane.add(comboDepartamentos);
		comboDepartamentos.addItem("Escolha um departamento");
		comboDepartamentos.addItem("Celulares");
		comboDepartamentos.addItem("Automotivos");

		// TODOS OS BOTÕES
		JButton btnCadastrar = new JButton("Cadastrar");
		JButton btnAlterar = new JButton("Alterar");
		JButton btnExcluir = new JButton("Excluir");
		JButton btnCancelar = new JButton("Cancelar");

		// AÇÃO DO BOTÃO CADASTRAR
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean jaFoi = false;
				Produtos pro = new Produtos();
				pro.setNome_produto(txtNome_produto.getText());
				pro.setValor_produto(Double.parseDouble(txtValor_produto.getText()));
				pro.setDepartamento_produto(comboDepartamentos.getSelectedItem().toString());

				// AÇÃO DE CADASTRO
				a.cadastrar(pro);
				// LIMPA OS CAMPOS
				limparCampos();
				table.setModel(a.selecionar());

				// SETAR STRING VAZIA PARA CADASTRAR OUTRO JOGO
				comboDepartamentos.setSelectedItem("Escolha um departamento");

			}
		});
		btnCadastrar.setBackground(Color.LIGHT_GRAY);
		btnCadastrar.setBounds(9, 123, 101, 23);
		contentPane.add(btnCadastrar);

		// AÇÃO DO BOTÃO ALTERAR
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produtos pro = new Produtos();
				pro.setNome_produto(txtNome_produto.getText());
				pro.setValor_produto(Double.parseDouble(txtValor_produto.getText()));
				pro.setDepartamento_produto(comboDepartamentos.getSelectedItem().toString());

				// REALIZAR A ALTERAÇÃO
				a.alterar(codigoProdutos, pro);
				// ATUALIZAR A LISTAGEM
				table.setModel(a.selecionar());
				// LIMPA OS CAMPOS
				limparCampos();
				// SETAR STRING VAZIA PARA CADASTRAR OUTRO JOGO
				comboDepartamentos.setSelectedItem("Escolha um departamento");

				// BOTÕES
				btnCadastrar.setEnabled(true);
				btnAlterar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnCancelar.setEnabled(false);

			}
		});
		btnAlterar.setBackground(Color.LIGHT_GRAY);
		btnAlterar.setBounds(119, 123, 96, 23);
		contentPane.add(btnAlterar);

		// AÇÃO DO BOTÃO EXCLUIR
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.excluir(codigoProdutos);
				// ATUALIZAR A LISTA
				table.setModel(a.selecionar());
				// LIMPA OS CAMPOS
				limparCampos();
				// SETAR STRING VAZIA PARA CADASTRAR OUTRO JOGO
				comboDepartamentos.setSelectedItem("Escolha um departamento");
				// BOTÕES
				btnCadastrar.setEnabled(true);
				btnAlterar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnCancelar.setEnabled(false);

			}
		});
		btnExcluir.setBackground(Color.LIGHT_GRAY);
		btnExcluir.setBounds(225, 123, 96, 23);
		contentPane.add(btnExcluir);

		// AÇÃO DO BOTÃO CANCELAR
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// LIMPAR OS CAMPOS
				limparCampos();
				// SETAR STRING VAZIA PARA CADASTRAR OUTRO JOGO
				comboDepartamentos.setSelectedItem("Escolha um departamento");
				// BOTÕES
				btnCadastrar.setEnabled(true);
				btnAlterar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnCancelar.setEnabled(false);

			}
		});
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.setBounds(331, 123, 96, 23);
		contentPane.add(btnCancelar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 157, 414, 163);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// OBTER O INDICE DA TABELA
				int indice = table.getSelectedRow();
				// OBTER O VALOR DO INDICE NO ATRIBUTO
				codigoProdutos = indice;
				// SELECIONANDO DADOS DO PRODUTO
				txtNome_produto.setText(table.getValueAt(indice, 0).toString());
				txtValor_produto.setText(table.getValueAt(indice, 1).toString());
				comboDepartamentos.setSelectedItem(table.getValueAt(indice, 2).toString());

				// BOTÕES
				btnCadastrar.setEnabled(false);
				btnAlterar.setEnabled(true);
				btnExcluir.setEnabled(true);
				btnCancelar.setEnabled(true);

			}
		});
		table.setModel(a.selecionar());
		scrollPane.setViewportView(table);
	}
}
