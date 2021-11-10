package usuarios;

import java.util.ArrayList;

/**
 * En esta clase se desarrollan los atributos de los jugadores
 * @author Alumno Aritz
 *
 */

public class Jugador extends Persona
{
	
	ArrayList<String> listaJugadores= new ArrayList <String>();
	
	private String piernaHabil;
	private double peso;
	private double altura;
	private String posicion;
	private int dorsal;
	
	/**
	 * Constructor con parametros
	 * @param nombre el nombre de la persona
	 * @param apellido1 el primer apellido de la persoma
	 * @param apellido2 el segundo apellido de la persona
	 * @param edad la edad de la persona
	 * @param dni el dni de la persona
	 * @param user el nombre de usuario de la persona
	 * @param password la contrasena de la persona
	 * @param email el correo de la persona
	 * @param tipopersona el tipo de persona que es en zubieta
	 * @param piernaHabil la pierna buena del jugador
	 * @param peso cuanto pesa el jugador
	 * @param altura cuanto mide el jugador
	 * @param posicion el puesto en el que juega el jugador
	 * @param dorsal el numero que lleva en la camiseta el jugador
	 */
	
	public Jugador(String nombre, String apellido1, String apellido2, int edad, String dni, String user,
			String password, String email, String tipopersona, String piernaHabil, double peso, double altura,
			String posicion, int dorsal) {
		super(nombre, apellido1, apellido2, edad, dni, user, password, email, tipopersona);
		this.piernaHabil = piernaHabil;
		this.peso = peso;
		this.altura = altura;
		this.posicion = posicion;
		this.dorsal = dorsal;
	}
	
	public Jugador ()
	{
		
	}
	
	/**
     * Este método devuelve la lista de jugadores a otra clase
     * @return listaJugadores
     */

	public ArrayList<String> getListaJugadores() {
		return listaJugadores;
	}
	
	/**
     * Este método da el valor a la lista de jugadores
     * @param  listaJugadores
     */

	public void setListaJugadores(ArrayList<String> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}
	
	/**
     * Este método devuelve el atributo piernaHabil a otra clase
     * @return piernaHabil
     */

	public String getPiernaHabil() {
		return piernaHabil;
	}
	
	/**
     * Este método da el valor al atributo piernaHabil
     * @param  piernaHabil
     */

	public void setPiernaHabil(String piernaHabil) {
		this.piernaHabil = piernaHabil;
	}
	
	/**
     * Este método devuelve el atributo peso a otra clase
     * @return peso
     */

	public double getPeso() {
		return peso;
	}
	
	/**
     * Este método da el valor al atributo peso
     * @param  peso
     */

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	/**
     * Este método devuelve el atributo altura a otra clase
     * @return altura
     */

	public double getAltura() {
		return altura;
	}
	
	/**
     * Este método da el valor al atributo altura
     * @param  altura
     */

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	/**
     * Este método devuelve el atributo posicion a otra clase
     * @return posicion
     */

	public String getPosicion() {
		return posicion;
	}
	
	/**
     * Este método da el valor al atributo posicion
     * @param posicion
     */

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	/**
     * Este método devuelve el atributo dorsal a otra clase
     * @return dorsal
     */

	public int getDorsal() {
		return dorsal;
	}
	
	/**
     * Este método da el valor al atributo dorsal
     * @param  dorsal
     */

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	
	

}
