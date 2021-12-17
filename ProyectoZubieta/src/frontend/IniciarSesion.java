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
	long entrenadorEncontrado = 0;
	long jugadorEncontrado = 0;
	
	
	

	/**
	 * Create the frame.
	 * @param listaJugadores la lista de todos los jugadores
	 * @param listaTecnicos la lista de todos los tecnicos 
	 * @param principio la ventana principio
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
		
		btnCancelar.addActionListener(
				e->
				{principio.setVisible(true);
				IniciarSesion.this.setVisible(false);
				});
		
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
					
					if(encontradoPersona) {
						//jugador.getTipopersona().equals("jugador") &&
						if( jugadorEncontrado == 1) {
							
							VentanaJugador ventana = new VentanaJugador((Jugador)jugador, IniciarSesion.this);
							ventana.setVisible(true);
							IniciarSesion.this.dispose();
							
							//tecnico.getTipopersona().equals("tecnico") &&
						} else if ( entrenadorEncontrado == 1) {
							
							VentanaTecnico ventanatec = new VentanaTecnico((Tecnico)tecnico, IniciarSesion.this);
							ventanatec.setVisible(true);
							IniciarSesion.this.dispose();
													
						}
							
					}
					
					
					
				} catch (UsuarioNoExiste e) {
					JOptionPane.showMessageDialog(IniciarSesion.this, e.getMessage());
				}
				
				
			}
		});
		panel.setLayout(null);
		panel.add(btnAceptar);
		
		
	}
	
	public  boolean comprobarPersona(String usuario, String password, ArrayList<Jugador> listaJugadores, ArrayList<Tecnico> listaTecnicos)
			throws UsuarioNoExiste 
    {

		boolean existe = false;
		long contador1=0;
		jugadorEncontrado = listaJugadores.stream().filter(s -> s.getUser().equals(usuario)).count();
		if (jugadorEncontrado==1) {
			
			Jugador jug = listaJugadores.stream().filter(s -> s.getUser().equals(usuario)).findFirst().get();
			
			if (jug.getUser().equals(usuario))
			{
//				existe = true;
				
				if (jug.getPassword().equals(password))
				{
					jugador =  jug;
					existe = true;
				}else {
					
					throw new UsuarioNoExiste("Contrasenya incorrecta");
					
				}
			}
			
		} 
		
		long contador2 = 0;
		entrenadorEncontrado = listaTecnicos.stream().filter(s -> s.getUser().equals(usuario)).count();
		
		
		if (entrenadorEncontrado == 1)
		{
			Tecnico t = listaTecnicos.stream().filter(s -> s.getUser().equals(usuario)).findFirst().get();
			
			if(t.getUser().equals(usuario))
			{
				existe = true;
				
				if (t.getPassword().equals(password)) 
				{
					
					tecnico = (Tecnico) t;
					existe = true;
					
				} else {
					
					throw new UsuarioNoExiste("Contrasenya incorrecta");

				}
			}
		}
		
			
		
		if(!existe) {
			
			throw new UsuarioNoExiste("Usuario no existe");
			
		}
		
		return true;
		
    }
	
	
}
