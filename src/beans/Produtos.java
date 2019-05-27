package beans;

public class Produtos {
	protected static final String Double = null;
	private String nome_produto, departamento_produto;
	double valor_produto;

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public double getValor_produto() {
		return valor_produto;
	}

	public void setValor_produto(double d) {
		this.valor_produto = d;
	}

	public String getDepartamento_produto() {
		return departamento_produto;
	}

	public void setDepartamento_produto(String departamento_produto) {
		this.departamento_produto = departamento_produto;
	}

}
