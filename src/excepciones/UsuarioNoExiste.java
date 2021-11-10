package excepciones;

public class UsuarioNoExiste extends Exception {
	
	/**
	 * Este método extiende de exception para poder mostrar posteriormente el mensaje de de error
	 * @param mensaje el mensaje que se va a mostrar
	 */
	
	
	public UsuarioNoExiste(String mensaje) {
		super(mensaje);
	}

}
