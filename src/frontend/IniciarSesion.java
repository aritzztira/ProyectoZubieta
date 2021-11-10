package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import usuarios.Jugador;
import usuarios.Persona;
import usuarios.Tecnico;
import frontend.Principio;
import excepciones.UsuarioNoExiste;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class IniciarSesion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	private String user;
	private String password;
	
	ArrayList<Jugador> listaJugadores;
	ArrayList<Tecnico> listaTecnicos;
	
	Persona jugador = new Jugador();
	Persona tecnico = new Tecnico();
	
	

	/**
	 * Create the frame.
	 */
	public IniciarSesion(ArrayList<Jugador> listaJugadores, ArrayList<Tecnico> listaTecnicos, Principio principio) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 428, 244);
		contentPane.add(panel);
		
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(233, 182, 115, 29);
		panel.add(btnCancelar);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(15, 86, 69, 20);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(15, 124, 98, 20);
		panel.add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(116, 83, 146, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(116, 121, 146, 26);
		panel.add(passwordField);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(116, 182, 87, 29);
		
		btnAceptar.addActionListener(new ActionListener() 
			{
			
			public void actionPerformed(ActionEvent arg0) 
			{
				user = textField.getText();
				
				password = passwordField.getText();
				
				try {
					
					boolean encontradoPersona = comprobarPersona (user, password, listaJugadores, listaTecnicos);
					
					
					
				} catch (UsuarioNoExiste e) {
					JOptionPane.showMessageDialog(IniciarSesion.this, e.getMessage());
				}
				
				
			}
		});
		panel.setLayout(null);
		panel.add(btnAceptar);
		
	}
	
	private boolean comprobarPersona(String usuario, String password, ArrayList<Jugador> listaJugadores, ArrayList<Tecnico> listaTecnicos)
			throws UsuarioNoExiste 
    {

		boolean existe = false;
		long contador1=0;
		
		for (Jugador jugador : listaJugadores) 
		{
			if(jugador.getUser().equals(usuario))
			{
				contador1+=1;
			}
		}
			
		
		

		if (contador1==1) {
			Jugador jug =new Jugador();
			
			for (Jugador jugador : listaJugadores) 
			{
				if(jugador.getUser().equals(usuario))
				{
					jug = jugador;
				}
			}
		
			
			
			
			if (jug.getUser().equals(usuario)) {
				existe = true;
				if (jug.getPassword().equals(password)) {
					jugador = (Persona) jug;
					tecnico= (Persona) jug;
					existe = true;
					
				} else {
					throw new UsuarioNoExiste("Contraseña incorrecta");
		
				}
			}
		} return existe;
		
    }
	
	
}
