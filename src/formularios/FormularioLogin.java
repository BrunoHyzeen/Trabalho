package formularios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import beans.Usuario;
import dados.DadosPessoa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class FormularioLogin extends FormularioLoja {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JButton btnsair;

	public FormularioLogin() {
		setResizable(false);
		Usuario u = new Usuario();

		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 219, 279);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Usu\u00E1rio");
		lblLogin.setBounds(10, 11, 48, 14);
		contentPane.add(lblLogin);

		txtLogin = new JTextField();
		txtLogin.setBounds(10, 36, 183, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 67, 48, 14);
		contentPane.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(10, 92, 183, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		// AÇÃO DO BOTÃO ACESSAR
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.setBackground(Color.LIGHT_GRAY);
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtLogin.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe um usuário por favor!");
					return;
				} else if (txtSenha.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe uma senha por favor!");
					return;
				}

				u.setNome_usuario(txtLogin.getText());
				u.setSenha_usuario(txtSenha.getText());
				for (int i = 0; i < DadosPessoa.arrayLogins.size(); i++) {
					if (u.getNome_usuario().contentEquals(DadosPessoa.arrayLogins.get(i).getNome_usuario())
							&& u.getSenha_usuario().contentEquals(DadosPessoa.arrayLogins.get(i).getSenha_usuario())) {

						setVisible(false);
						new FormularioLoja().setVisible(true);
					} else if (u.getNome_usuario() != DadosPessoa.arrayLogins.get(i).getNome_usuario()) {

						if (txtLogin.getText().equals("Bruno") && txtSenha.getText().equals("123")) {
							// abre a tela
							new FormularioProdutos().setVisible(true);

						}
					}
				}

			}

		});
		btnAcessar.setBounds(56, 138, 89, 23);
		contentPane.add(btnAcessar);

		btnsair = new JButton("Sair");
		btnsair.setBackground(Color.LIGHT_GRAY);
		btnsair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
		btnsair.setBounds(56, 183, 89, 23);
		contentPane.add(btnsair);

	}
}
