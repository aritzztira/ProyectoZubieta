
package frontend;

import javax.swing.JPanel;

import usuarios.Jugador;
import usuarios.Tecnico;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import excepciones.UsuarioNoExiste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BuscarJugadorr extends JFrame {
	
	private JPanel contentFrame;
	private JTextField textField;
	
	private String user;
	Jugador jugador;
	VentanaJugador venJug;

	/**
	 * Create the panel.
	 */
	public BuscarJugadorr(VentanaTecnico venTec, IniciarSesion ventana) {
		setLayout(null);
		
		JLabel lblQueJugadorQuieres = new JLabel("Que jugador quieres buscar?");
		lblQueJugadorQuieres.setBounds(32, 70, 247, 31);
		add(lblQueJugadorQuieres);
		
		textField = new JTextField();
		textField.setBounds(32, 140, 146, 26);
		add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(15, 211, 115, 29);
		btnBuscar.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0) 
			
			{
				
				user = textField.getText();
				
				VentanaJugador ventanaJugador = new VentanaJugador(jugador, ventana);
				
//				try {
//					
//					boolean encontradoPersona = comprobarPersona (user, listaJugadores);
//					
//					if(encontradoPersona) {
//						//jugador.getTipopersona().equals("jugador") &&
//						if( jugadorEncontrado == 1) {
//							
//							VentanaJugador ventana = new VentanaJugador((Jugador)jugador, IniciarSesion );
//							ventana.setVisible(true);
//							BuscarJugadorr.this.dispose();
//							
//							
//						} 
//							
//					}
//					
//					
//					
//				} catch (UsuarioNoExiste e) {
//					JOptionPane.showMessageDialog(BuscarJugadorr.this, e.getMessage());
//				}
				
				
			}
		});
				
		add(btnBuscar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(162, 211, 115, 29);
		btnAtras.addActionListener(
				e->
				{venTec.setVisible(true);
				BuscarJugadorr.this.setVisible(false);
				});
		add(btnAtras);
		
		JButton btnCerrarSesion = new JButton("Cerrar sesion");
		btnCerrarSesion.setBounds(305, 211, 130, 29);
		btnCerrarSesion.addActionListener(
				e->
				{ventana.setVisible(true);
				BuscarJugadorr.this.setVisible(false);
				});
		add(btnCerrarSesion);
		
		
		
		

	}

}


