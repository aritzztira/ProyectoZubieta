package usuarios;

import java.util.ArrayList;

public class Tecnico extends Persona
{
	ArrayList<String> listaTecnicos= new ArrayList <String>();
	
	private String titulacion;
	private String categoria;
	private int anyosExperiencia;
	
	/**
	 * Es un constructor con parametros
	 * @param nombre el nombre del tecnico
	 * @param apellido1 el primer apellido del tecnico
	 * @param apellido2 el segundo apellido del tecnico
	 * @param edad la edad del tecnico
	 * @param dni el numero del dni del tecnico
	 * @param user el user del tecnico
	 * @param password el password del tecnico
	 * @param email el correo del tecnico
	 * @param tipopersona sirve para saber que es un tecnico
	 * @param titulacion para saber que titulo tiene el tecnico 
	 * @param categoria la categoria en la que milita
	 * @param anyosExperiencia cuantos anos lleva siendo tecnico
	 */
	
	
	public Tecnico(String nombre, String apellido1, String apellido2, int edad, String dni, String user,
			String password, String email, String tipopersona, String titulacion, String categoria, int anyosExperiencia) {
		super(nombre, apellido1, apellido2, edad, dni, user, password, email, tipopersona);
		this.titulacion = titulacion;
		this.categoria = categoria;
		this.anyosExperiencia = anyosExperiencia;
	}
	
	/**
	 * Constructor sin parametros
	 */
	
	public Tecnico()
	{
		
	}
	
	/**
     * Este método devuelve la lista de tecnicos a otra clase
     * @return listaTecnicos
     */

	public ArrayList<String> getListaTecnicos() {
		return listaTecnicos;
	}
	
	/**
     * Este método da el valor a la lista de tecnicos
     * @param  listaTecnicos
     */

	public void setListaTecnicos(ArrayList<String> listaTecnicos) {
		this.listaTecnicos = listaTecnicos;
	}
	
	/**
     * Este método devuelve el atributo titulacion a otra clase
     * @return titulacion
     */

	public String getTitulacion() {
		return titulacion;
	}
	
	/**
     * Este método da el valor al atributo titulacion
     * @param  titulacion
     */

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}
	
	/**
     * Este método devuelve el atributo categoria a otra clase
     * @return categoria
     */

	public String getCategoria() {
		return categoria;
	}
	
	/**
     * Este método da el valor al atributo categoria
     * @param  categoria
     */

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	/**
     * Este método devuelve el atributo anos de experiencia a otra clase
     * @return anyosExperiencia
     */

	public int getAnyosExperiencia() {
		return anyosExperiencia;
	}
	
	/**
     * Este método da el valor al atributo anos de experiencia
     * @param  anyosExperiencia
     */

	public void setAnyosExperiencia(int anyosExperiencia) {
		this.anyosExperiencia = anyosExperiencia;
	}
	
	

}
