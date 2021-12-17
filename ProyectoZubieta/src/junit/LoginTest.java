package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.UsuarioNoExiste;
import frontend.IniciarSesion;
import frontend.Principio;
import sqlite.BaseDatos;
import usuarios.Jugador;
import usuarios.Tecnico;

class LoginTest {
	
	private String usuario;
	private String password;
	private ArrayList<Jugador> listaJug;
	private ArrayList<Tecnico> listaTec;
	private IniciarSesion ini;
	

	@BeforeEach
	void setUp() throws Exception {
		
		usuario = "aritzztira";
		password = "aritz";
		listaJug = BaseDatos.selectAllJugadores();
		listaTec = BaseDatos.selectAllTecnicos();
		ini = new IniciarSesion(listaJug, listaTec, new Principio());
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
		listaJug = null;
		listaTec = null;
		ini = null;
		
	}

	@Test
	void test() {
		
		try {
			assertTrue(ini.comprobarPersona(usuario, password, listaJug, listaTec));
		} catch (UsuarioNoExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
