package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import usuarios.Persona;
import usuarios.Tecnico;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaTecnico extends JFrame {

	private JPanel contentPane;
	
	private String user;

	/**
	 * Launch the application.
	 */


	
	/**
	 * Create the frame.
	 */
	public VentanaTecnico(Tecnico tecnico, IniciarSesion ventana) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTecnico = new JLabel("Tecnico: " + tecnico.getNombre() + " " + tecnico.getApellido1() + " " + tecnico.getApellido2());
		lblTecnico.setBounds(95, 16, 266, 20);
		contentPane.add(lblTecnico);
		
		JLabel lblNewLabel = new JLabel("Edad: " + tecnico.getEdad());
		lblNewLabel.setBounds(15, 57, 69, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblTitulacin = new JLabel("Titulaci\u00F3n: " + tecnico.getTitulacion());
		lblTitulacin.setBounds(15, 99, 254, 20);
		contentPane.add(lblTitulacin);
		
		JLabel lblCategoria = new JLabel("Categoria:" + tecnico.getCategoria());
		lblCategoria.setBounds(15, 149, 278, 20);
		contentPane.add(lblCategoria);
		
		JButton btnAtras = new JButton("Atras:");
		btnAtras.setBounds(274, 199, 115, 29);
		btnAtras.addActionListener(
				e-> 
				{ventana.setVisible(true);
				VentanaTecnico.this.setVisible(false);
				});
		
		contentPane.add(btnAtras);
		
		JButton btnBuscarJugador = new JButton("Buscar jugador");
		btnBuscarJugador.addActionListener(
				e->
				{
					BuscarJugadorr ventanaBuscar = new BuscarJugadorr(VentanaTecnico.this, ventana);
					ventanaBuscar.setVisible(true);
					VentanaTecnico.this.dispose();
				});
		btnBuscarJugador.setBounds(49, 199, 139, 29);
		contentPane.add(btnBuscarJugador);
	}
}
