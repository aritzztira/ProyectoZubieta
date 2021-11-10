package usuarios;

/**
 * En esta clase se desarrollan los atributos de las personas
 * @author Alumno Aritz
 *
 */

public abstract class Persona 
{
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private String dni;
	private String user;
	private String password;
	private String email;
	private String tipopersona;
	
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
	 */
	
	
	public Persona(String nombre, String apellido1, String apellido2, int edad, String dni, String user,
			String password, String email, String tipopersona) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
		this.dni = dni;
		this.user = user;
		this.password = password;
		this.email = email;
		this.tipopersona = tipopersona;
	}
	
	public Persona ()
	{
		
	}
	
	/**
	 * Este metodo devuelve el atributo nombre a otra clase
	 * @return nombre
	 */

	public String getNombre() {
		return nombre;
	}
	
	/**
     * Este método da el valor al atributo nombre
     * @param nombre 
     */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Este metodo devuelve el atributo primer apellido a otra clase
	 * @return apellido1
	 */

	public String getApellido1() {
		return apellido1;
	}
	
	/**
     * Este método da el valor al atributo primer apellido
     * @param apellido1
     */

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	
	/**
	 * Este metodo devuelve el atributo segundo apellido a otra clase
	 * @return
	 */

	public String getApellido2() {
		return apellido2;
	}
	
	/**
     * Este método da el valor al atributo segundo apellido
     * @param apellido2
     */

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	/**
	 * Este metodo devuelve el atributo edad a otra clase
	 * @return edad
	 */

	public int getEdad() {
		return edad;
	}
	
	/**
     * Este método da el valor al atributo edad
     * @param edad
     */

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	/**
	 * Este metodo devuelve el atributo dni a otra clase
	 * @return dni
	 */

	public String getDni() {
		return dni;
	}
	
	/**
     * Este método da el valor al atributo dni
     * @param dni
     */

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * Este metodo devuelve el atributo user a otra clase
	 * @return
	 */

	public String getUser() {
		return user;
	}
	
	/**
     * Este método da el valor al atributo usuario
     * @param user
     */

	public void setUser(String user) {
		this.user = user;
	}
	
	/**
	 * Este metodo devuelve el atributo contrasena a otra clase
	 * @return password
	 */

	public String getPassword() {
		return password;
	}
	
	/**
     * Este método da el valor al atributo contrasena
     * @param password
     */

	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Este metodo devuelve el atributo email a otra clase
	 * @return
	 */

	public String getEmail() {
		return email;
	}
	
	/**
     * Este método da el valor al atributo email
     * @param email
     */

	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Este metodo devuelve el atributo tipo de persona a otra clase
	 * @return tipopersona
	 */

	public String getTipopersona() {
		return tipopersona;
	}
	
	/**
     * Este método da el valor al atributo tipopersona
     * @param tipopersona
     */

	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}
	
	
	

}
