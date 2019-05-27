package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beans.Usuario;
import dados.DadosPessoa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FormularioCadastrar extends FormularioLogin {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	public FormularioCadastrar() {
		setResizable(false);
		Usuario u = new Usuario();
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 215, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(10, 11, 48, 14);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(10, 36, 180, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblUsuario = new JLabel("Usu\u00E1rio");
		lblUsuario.setBounds(10, 67, 48, 14);
		contentPane.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(10, 92, 180, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 123, 48, 14);
		contentPane.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(10, 148, 180, 20);
		contentPane.add(txtSenha);
		// AÇÃO DO BOTÃO CADASTRAR
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(Color.LIGHT_GRAY);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtEmail.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe um e-mail por favor!");
					return;
				} else if (txtUsuario.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe um usuário por favor!");
					return;
				} else if (txtSenha.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe uma senha por favor!");
					return;
				}

				u.setNome_usuario(txtUsuario.getText());
				u.setSenha_usuario(txtSenha.getText());
				DadosPessoa.arrayLogins.add(u);

				setVisible(false);
				new FormularioLogin().setVisible(true);

			}
		});
		btnCadastrar.setBounds(47, 197, 110, 23);
		contentPane.add(btnCadastrar);

	}

}
