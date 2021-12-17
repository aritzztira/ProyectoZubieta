package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import usuarios.Jugador;
import usuarios.Persona;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaJugador extends JFrame {

	private JPanel contentPane;
	
	

	/**
	 * Launch the application.
	 */

	
	/**
	 * Create the frame.
	 */
	public VentanaJugador(Jugador jugador, IniciarSesion ventana) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJugador = new JLabel("Jugador: " + jugador.getNombre() + " " + jugador.getApellido1());
		lblJugador.setBounds(102, 16, 249, 20);
		contentPane.add(lblJugador);
		
		JLabel lblEdad = new JLabel("Edad: " + jugador.getEdad());
		lblEdad.setBounds(15, 64, 123, 20);
		contentPane.add(lblEdad);
		
		JLabel lblNewLabel = new JLabel("Posicion: " + jugador.getPosicion());
		lblNewLabel.setBounds(15, 100, 207, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblB = new JLabel("Dorsal: " + jugador.getDorsal());
		lblB.setBounds(15, 139, 123, 20);
		contentPane.add(lblB);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				VentanaJugador.this.setVisible(false);
				ventana.setVisible(true);
				
			}
		});
		btnAtras.setBounds(283, 199, 115, 29);
		contentPane.add(btnAtras);
		
		
	}
}
