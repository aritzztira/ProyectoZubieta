package frontend;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sqlite.BaseDatos;
import usuarios.Jugador;
import usuarios.Tecnico;


public class Principio extends JFrame {

	private JPanel contentPane;
	
	
	ArrayList<Jugador> listaJugadores;
    ArrayList <Tecnico> listaTecnicos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principio frame = new Principio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principio() {
		listaJugadores= BaseDatos.selectAllJugadores();
	    listaTecnicos= BaseDatos.selectAllTecnicos();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel foto = new JLabel("New label");
		foto.setIcon(new ImageIcon("images/Deusto.jpg"));
		foto.setBounds(15, 16, 398, 176);
		contentPane.add(foto);

		JButton btnInicio = new JButton("Iniciar sesión");
		btnInicio.addActionListener(new ActionListener() {
			
			/**
			 * Aquí se clica para iniciar sesión
			 */
			public void actionPerformed(ActionEvent arg0) {
				
				IniciarSesion ventana = new IniciarSesion(listaJugadores, listaTecnicos, Principio.this);
				ventana.setVisible(true);
				Principio.this.dispose();
			}
		});
		btnInicio.setBounds(129, 199, 135, 29);
		contentPane.add(btnInicio);

		JButton btnSalir = new JButton("Salir");
		
		
		btnSalir.addActionListener(e -> 
		{
				
				Principio.this.dispose();
		});
		
		btnSalir.setBounds(275, 199, 149, 29);
		contentPane.add(btnSalir);
	}

}
