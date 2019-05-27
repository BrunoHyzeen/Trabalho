package acao;

import javax.swing.table.DefaultTableModel;

import beans.Produtos;
import dados.DadosProdutos;

public class Acao {
	// CADASTRO
	public void cadastrar(Produtos p) {
		DadosProdutos.arrayProduto.add(p);

	}

	// SELE��O
	public DefaultTableModel selecionar() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nome do produto");
		modelo.addColumn("Pre�o");
		modelo.addColumn("Departamento");

		for (int indice = 0; indice < DadosProdutos.arrayProduto.size(); indice++) {
			modelo.addRow(new Object[] { DadosProdutos.arrayProduto.get(indice).getNome_produto(),
					DadosProdutos.arrayProduto.get(indice).getValor_produto(),
					DadosProdutos.arrayProduto.get(indice).getDepartamento_produto() });
		}
		return modelo;

	}

	// ALTERA��O
	public void alterar(int indice, Produtos p) {
		DadosProdutos.arrayProduto.set(indice, p);
	}

	// EXCLUS�O
	public void excluir(int indice) {
		DadosProdutos.arrayProduto.remove(indice);
	}

}
