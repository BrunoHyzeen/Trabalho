package principal;

import beans.Usuario;
import dados.DadosPessoa;
import formularios.FormularioCadastrar;
import formularios.FormularioLoja;
import formularios.FormularioProdutos;

public class Principal {

	public static void main(String[] args) {

		// EXIBIR FORMULARIOS
		FormularioCadastrar fc = new FormularioCadastrar();
		fc.setVisible(true);
		// USUARIO ADMINISTRADOR
		Usuario us = new Usuario();
		us.setNome_usuario("Bruno");
		us.setSenha_usuario("123");
		us.setAdministrador(true);

		DadosPessoa.arrayLogins.add(us);
	}

}
