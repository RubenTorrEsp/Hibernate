package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertaAlumno {
	
	private static final String fichero = "Alumnado_nuevo.txt";

	public static void main(String[] args) throws IOException {
		crearTablaSuperusuarios(fichero);
	}

	
	/**
	 * Método que recibe como parámetro el nombre de un archivo. 
	 * Creará una tabla llamada “Superusuarios” en la base de datos
	 * y añadirá el contenido de ese fichero a la tabla.
	 * 
	 * @param ruta
	 * @throws IOException
	 */
	private static void crearTablaSuperusuarios(String ruta) throws IOException {
		
		//Iniciamos los objetos que necesitaremos para la lectura del archivo
		BufferedReader lector = null;
		String linea = null;
		ArrayList<SuperUsuario> listaSuperUsuarios = new ArrayList<SuperUsuario>();
		
		//Leemos el archivo e insertamos cada línea en la lista
		lector = new BufferedReader(new FileReader(ruta));
		
		//Añadimos los usuarios a la lista
		try {
			
			//Leemos las líneas del archivo hasta que lleguemos al final
			while ((linea = lector.readLine()) != null) {
			String[] campos = linea.split(",");
			String apellidos = campos[0];
			String nombre = campos[1];
			String user = "2DAM" + nombre.charAt(1) + apellidos.charAt(0);

			//Añadimos superUsuarios a la lista
			listaSuperUsuarios.add(new SuperUsuario(nombre, apellidos, user));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Cerramos el lector
		lector.close();
		
		//Inicializador de los objetos de hibernate
		SessionFactory miSF = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(SuperUsuario.class)
				.buildSessionFactory();
		
		//Inicio de la sesión (conexion)
		Session miSession = miSF.openSession();

		try {
			
			//Iniciamos el proceso hibernate
			miSession.beginTransaction();
			
			//Guardamos todos los objetos de tipo SuperUsuario en la BD
			for (SuperUsuario superUsuario : listaSuperUsuarios) {
				miSession.save(superUsuario);
			}

			//Realizamos el commit
			miSession.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//Cerramos los objetos de hibernate
			miSession.close();
			miSF.close();
		}		
	
	}

}