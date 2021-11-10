package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import usuarios.Jugador;
import usuarios.Tecnico;

public class BaseDatos 
{
	
	private static Connection conn;
    private static String BDnombre;
    private final static String URL = "jdbc:sqlite:";

    
    /**
     * Es el constructor
     * @param BDnombre el nombre de la base de datos
     */
    
	    public BaseDatos(String BDnombre)
	    {
	        BaseDatos.BDnombre = URL + BDnombre;
	
	    }
	    
	    /**
	     * Lanza el gestor
	     * @param args args
	     */
	    
	    public static void main (String [] args)
	    {
	        BaseDatos myDBManager;
	  

	        try
	        {
	            // Step 1 - Instantiate the manager
	            myDBManager= new BaseDatos("ZubietaOrganigrama.db");

	            // Step 2 - Create database
	            BaseDatos.createLink();

	            // Step 3 - Create table
	            BaseDatos.createNewTableJugador();
	            BaseDatos.createNewTableTecnico();
	            
	            BaseDatos.insertJugador("aritz", "aldasoro", "sarriegi", 21, "72605630N", "aritzztira", "aritz", "aritzaldas9@gmail.com", "jugador", "diestro", 72, 176, "mediocentro", 8);
	            BaseDatos.insertJugador("Imanol", "Galarreta" , "Torres" , 20, "72605636N" , "imanolgala", "manzana", "igalarreta@gmail.com", "jugador", "diestro", 67, 172, "delantero", 29);
	            BaseDatos.insertJugador("Aitor", "Aranzabe" , "Etxabe" , 22, "72476817J" , "aitoraran", "mesa", "aranzabe11@gmail.com", "jugador", "zurdo", 75, 178, "defensa", 17);
	            BaseDatos.insertTecnico("Sebastian", "Parrilla", "Gonzalez", 52, "44728374L", "sebas", "real", "sebasparri@gmail.com", "tecnico", "entrenador", "2B", 14);
	            BaseDatos.insertTecnico("Oier", "Arrizabalaga", "Etxaniz", 43, "44457874M", "poxi", "fitnes", "oierarri@gmail.com", "tecnico", "preparador", "2B", 8);
	            BaseDatos.insertTecnico("Jon", "Aleman", "Exposito", 48, "44723674H", "jonale", "gol", "jon.aleman@gmail.com", "tecnico", "analista", "2B", 14);
	            
	            // Last step - Close connection
	            BaseDatos.closeLink();
	        }
	        catch (SQLException e)
	        {
	            System.out.println("Process terminated with errors");
	        }
	        finally
	        {
	            System.out.println("Process terminated successfully");
	        }
	    }
	    

	/**
	 * Sirve para crear la conexión con la base de datos
	 * @throws SQLException si no se puede realizar salta la excepción sqlexception
	 */
	
	    public static void createLink() throws SQLException
	    {
	        try
	        {
	            conn = DriverManager.getConnection(BDnombre); 
	        }
	        catch (SQLException e)
	        {
	            System.out.println("BadAss error creating connection. " + e.getMessage());
	        }
	    }
	    
	    /**
	     * Sirve para crear una nueva tabla de jugador
	     * @throws SQLException si no se puede realizar salta la excepción sqlexception
	     */
	
	        public static void createNewTableJugador() throws SQLException
	    {
	
	        // SQL statement for creating a new table
	        String sql = "CREATE TABLE IF NOT EXISTS jugador (\n"
	                + "    nombre text NOT NULL,\n"
	                + "    apellido1 text NOT NULL,\n"
	                + "    apellido2 text NOT NULL,\n"
	                + "    edad text NOT NULL,\n"
	                + "    dni text NOT NULL,\n"
	                + "    user text NOT NULL,\n"
	                + "    password text NOT NULL,\n"
	                + "    email text NOT NULL,\n"
	                + "    tipopersona text NOT NULL,\n"
	                + "    piernaHabil real NOT NULL,\n"
	                + "    peso integer NOT NULL,\n"
	                + "    altura integer NOT NULL,\n"
	                + "    posicion integer NOT NULL,\n"
	                + "    dorsal text NOT NULL\n"
	                + ");";
	
	        try
	                (
	                        Statement stmt = conn.createStatement()
	                )
	        {
	            //create a table
	
	            stmt.execute(sql);
	
	        } catch (SQLException e)
	        {
	            System.out.println("BadAss error creating table" + e.getMessage());
	            System.out.println(sql);
	        }
	    }
	        
        /**
         * Sirve para crear una nueva tabla de tecnico
         * @throws SQLException si no se puede realizar salta la excepción sqlexception
         */
	
	    public static void createNewTableTecnico() throws SQLException
	    {
	
	        // SQL statement for creating a new table
	        String sql = "CREATE TABLE IF NOT EXISTS tecnico (\n"
	                + "    nombre text NOT NULL,\n"
	                + "    apellido1 text NOT NULL,\n"
	                + "    apellido2 text NOT NULL,\n"
	                + "    edad text NOT NULL,\n"
	                + "    dni text NOT NULL,\n"
	                + "    user text NOT NULL,\n"
	                + "    password text NOT NULL,\n"
	                + "    email text NOT NULL,\n"
	                + "    tipopersona text NOT NULL,\n"
	                + "    titulacion text NOT NULL,\n"
	                + "    categoria text NOT NULL,\n"
	                + "    anyosExperiencia text NOT NULL\n"
	                + ");";
	
	        try
	                (
	                        Statement stmt = conn.createStatement()
	                )
	        {
	
	            boolean result=stmt.execute(sql);
	
	        } catch (SQLException e)
	        {
	            System.out.println("BadAss error creating table "+e.getMessage());
	            System.out.println(sql);
	        }
	    }
	    
	    /**
	     * Sirve para insertar un tecnico
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
	     * @throws SQLException si no se puede realizar salta la excepción sqlexception
	     */
	
	    public static void insertTecnico(String nombre, String apellido1, String apellido2, int edad, String dni, String user,
				String password, String email, String tipopersona, String titulacion, String categoria, int anyosExperiencia) throws SQLException{
	
	        String sql = "INSERT INTO tecnico(nombre, apellido1, apellido2, edad, dni, user, password," +
	                "email, tipopersona, titulacion, categoria, anyosExperiencia) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
	    	
	
	        try
	                (
	                        Connection conn= connect(); 
	                		PreparedStatement pstmt = conn.prepareStatement(sql) 		
	                )
	        {
	            
	            pstmt.setString(1, nombre);
	            pstmt.setString(2, apellido1);
	            pstmt.setString(3, apellido2);
	            pstmt.setInt(4, edad);
	            pstmt.setString(5, dni);
	            pstmt.setString(6, user);
	            pstmt.setString(7, password);
	            pstmt.setString(8, email);
	            pstmt.setString(9, tipopersona);
	            pstmt.setString(10, titulacion);
	            pstmt.setString(11, categoria);
	            pstmt.setInt(12, anyosExperiencia);
	            
	           
	
	            pstmt.executeUpdate();
	        }
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }
	    
	    /**
	     * * Sirve para insertar un jugador
	     * @param nombre el nombre del jugador
	     * @param apellido1 el primer apellido del jugador
	     * @param apellido2 el segundo apellido del jugador
	     * @param edad la edad del jugador
	     * @param dni el numero del dni del jugador
	     * @param user el user del jugador
	     * @param password el password del jugador
	     * @param email el correo del jugador
	     * @param tipopersona demuestra que es un jugador
	     * @param piernaHabil la pierna buena del jugador
	     * @param peso cuanto pesa el jugador
	     * @param altura cuanto mide el jugador
	     * @param posicion el puesto en el que juega el jugador
	     * @param dorsal el numero que lleva en la camiseta el jugador
	     * @throws SQLException si no se puede realizar salta la excepción sqlexception
	     */
	
	
	    public static void insertJugador(String nombre, String apellido1, String apellido2, int edad, String dni, String user,
				String password, String email, String tipopersona, String piernaHabil, double peso, double altura,
				String posicion, int dorsal) throws SQLException{
	
	        String sql = "INSERT INTO jugador(nombre, apellido1, apellido2, edad,  dni, user, password, email," + 
	        		"tipopersona, piernaHabil, peso, altura, posicion, dorsal) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	        try
	                (
	                        Connection conn=connect();
	                		PreparedStatement pstmt = conn.prepareStatement(sql) //
	                )
	        {
	            pstmt.setString(1, nombre);
	            pstmt.setString(2, apellido1);
	            pstmt.setString(3, apellido2);
	            pstmt.setInt(4, edad);
	            pstmt.setString(5, dni);
	            pstmt.setString(6, user);
	            pstmt.setString(7, password);
	            pstmt.setString(8, email);
	            pstmt.setString(9, tipopersona);
	            pstmt.setString(10, piernaHabil);
	            pstmt.setDouble(11, peso);
	            pstmt.setDouble(12, altura);
	            pstmt.setString(13, posicion);
	            pstmt.setInt(14, dorsal);
	
	            pstmt.executeUpdate();
	        }
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }
	    
	    /**
	     * Es la clase que devuelve el array de tecnicos de la base de datos
	     * @return diccionarioTrabajadores devuelve todos los tecnicos
	     */
	    
	    public static ArrayList<Tecnico> selectAllTecnicos()
	    {

	        ArrayList <Tecnico> listaTecnicos= new ArrayList <>();
	        String sql = "SELECT nombre, apellido1, apellido2, edad, dni, user, password, email, tipopersona, titulacion, categoria, anyosExperiencia FROM Tecnico";
	        try
	                (
	                        Connection conn = connect(); 
	                        Statement stmt  = conn.createStatement();
	                        ResultSet rs    = stmt.executeQuery(sql) 
	                )
	        {

	            
	            while (rs.next()) 
	            {

	                String nombre = rs.getString("nombre");
	                String apellido1 = rs.getString("apellido1");
	                String apellido2 = rs.getString("apellido2");
	                Integer edad = rs.getInt("edad");
	                String dni = rs.getString("dni");
	                String user = rs.getString("user");
	                String password = rs.getString("password");
	                String email = rs.getString("email");
	                String tipopersona = rs.getString("tipopersona");
	                String titulacion = rs.getString("titulacion");
	                String categoria = rs.getString("categoria");
	                Integer anyosExperiencia = rs.getInt("anyosExperiencia");
	                
	                Tecnico tecnico = new Tecnico(nombre, apellido1, apellido2, edad, dni, user, password, email, tipopersona, titulacion, categoria, anyosExperiencia);
	                listaTecnicos.add(tecnico);


	            }
	        }
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }

	        return listaTecnicos;

	    }
	    
	    /**
	     * Seleccionar todos los jugadores
	     * @return la lista de todos los jugadores
	     */

	    public static ArrayList<Jugador> selectAllJugadores()
	    {

	        ArrayList <Jugador> listaJugadores= new ArrayList <>();
	        String sql = "SELECT nombre, apellido1, apellido2, edad,  dni, user, password, email, tipopersona, piernaHabil, peso, altura, posicion, dorsal  FROM Jugador";

	        try
	                (
	                	
	                        Connection conn = connect();
	                        Statement stmt  = conn.createStatement();
	                        ResultSet rs    = stmt.executeQuery(sql) 
	                )
	        {

	            
	            while (rs.next()) 
	            {
	            	
	            	String nombre = rs.getString("nombre");
		            String apellido1 = rs.getString("apellido1");
		            String apellido2 = rs.getString("apellido2");
		            Integer edad = rs.getInt("edad");
		            String dni = rs.getString("dni");
		            String user = rs.getString("user");
		            String password = rs.getString("password");
		            String email = rs.getString("email");
		            String tipopersona = rs.getString("tipopersona");
		            String piernaHabil = rs.getString("piernaHabil");
		            Integer peso = rs.getInt("peso");
		            Integer altura = rs.getInt("altura");
		            String posicion = rs.getString("posicion");
		            Integer dorsal = rs.getInt("dorsal");

	                Jugador jugador = new Jugador(nombre, apellido1, apellido2, edad, dni, user, password, email, tipopersona, piernaHabil, peso, altura, posicion, dorsal);
	                listaJugadores.add(jugador);
	               

	            }
	        }
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }

	        return listaJugadores;

	    }
	    
	    /**
	     * Sirve para realizar la conexión
	     * @return
	     */
	
	    private static Connection connect() 
	    {
	        // SQLite connection string
	    	String name = "ZubietaOrganigrama.db";
	    	//String url= BDnombre;
	    	String url = "jdbc:sqlite:" + name;
	    	
	        Connection conn = null;
	
	        try
	        {
	            conn = DriverManager.getConnection(url);
	        }
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }
	        return conn;
	    }
	    
	    /**
	     * Devuelve la lista de jugadores de la base de datos creada para junit
	     * @return la lista de jugadores
	     */
	    
	    public static ArrayList<Jugador> selectAllJugadoresJunit()
	    {

	        ArrayList <Jugador> listaJugadores= new ArrayList <>();
	        String sql = "SELECT nombre, apellido1, apellido2, edad, dni, user, password, email, tipopersona, " +
	                "piernaHabil, peso, altura, posicion, dorsal  FROM Jugador";

	        try
	                (
	                        Connection conn = connectJunit();
	                        Statement stmt  = conn.createStatement();
	                        ResultSet rs    = stmt.executeQuery(sql) 
	                )
	        {

	            
	            while (rs.next()) 
	            {
	            	
	            	String nombre = rs.getString("nombre");
		            String apellido1 = rs.getString("apellido1");
		            String apellido2 = rs.getString("apellido2");
		            Integer edad = rs.getInt("edad");
		            String dni = rs.getString("dni");
		            String user = rs.getString("user");
		            String password = rs.getString("password");
		            String email = rs.getString("email");
		            String tipopersona = rs.getString("tipopersona");
		            String piernaHabil = rs.getString("piernaHabil");
		            Integer peso = rs.getInt("peso");
		            Integer altura = rs.getInt("altura");
		            String posicion = rs.getString("posicion");
		            Integer dorsal = rs.getInt("dorsal");

	                Jugador jugador = new Jugador(nombre, apellido1, apellido2, edad, dni, user, password, email, tipopersona, piernaHabil, peso, altura, posicion, dorsal);
	                listaJugadores.add(jugador);

	                

	            }
	        }
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }

	        return listaJugadores;

	    }
	    
	    /**
	     * Devuelve la lista de tecnicos de la base de datos creada para junit
	     * @return la lista de tecnicos
	     */
	    
	    public static ArrayList<Tecnico> selectAllTecnicosJunit()
	    {

	        ArrayList <Tecnico> listaTecnicos= new ArrayList <>();
	        String sql = "SELECT nombre, apellido1, apellido2, edad, dni, user, password, email, tipopersona, titulacion, categoria, anyosExperiencia FROM Tecnico";

	        try
	                (
	                        Connection conn = connectJunit();
	                        Statement stmt  = conn.createStatement();
	                        ResultSet rs    = stmt.executeQuery(sql) 
	                )
	        {

	            
	            while (rs.next()) 
	            {
	            	
	            	String nombre = rs.getString("nombre");
	                String apellido1 = rs.getString("apellido1");
	                String apellido2 = rs.getString("apellido2");
	                Integer edad = rs.getInt("edad");
	                String dni = rs.getString("dni");
	                String user = rs.getString("user");
	                String password = rs.getString("password");
	                String email = rs.getString("email");
	                String tipopersona = rs.getString("tipopersona");
	                String titulacion = rs.getString("titulacion");
	                String categoria = rs.getString("categoria");
	                Integer anyosExperiencia = rs.getInt("anyosExperiencia");

	                Tecnico tecnico = new Tecnico(nombre, apellido1, apellido2, edad, dni, user, password, email, tipopersona, titulacion, categoria, anyosExperiencia);
	                listaTecnicos.add(tecnico);
	                

	            }
	        }
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }

	        return listaTecnicos;

	    }
	    
	    /**
	     * Realiza la conexion con la base de datos creada para junit
	     * @return la conexion
	     */
	    
	    private static Connection connectJunit() 
	    {
	        // SQLite connection string
	    	String name = "ZubietaOrganigrama.db";
	    	//String url= BDnombre;
	    	String url = "jdbc:sqlite:" + name;
	    	
	        Connection conn = null;
	
	        try
	        {
	            conn = DriverManager.getConnection(url);
	        }
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }
	        return conn;
	    }
	    /**
	     * Sirve para cerrar la conexión
	     * @throws SQLException si no se puede realizar salta la excepción sqlexception
	     */
	    
	    public static void closeLink()throws SQLException{
	
	        try{
	
	            if(conn != null){
	
	                conn.close();
	            }
	        }
	        catch (SQLException ex){
	
	            System.out.println("BadAss error closing connection" +ex.getMessage());
	
	        }
	
	
	    }    
	    
	    public static void setNameBD(){
	    	
	    	BaseDatos.BDnombre = URL + BDnombre;
	    	
	    }
	
	

}
