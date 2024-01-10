package Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertaAlumno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Lectura del archivo de configuración
		SessionFactory miSF = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Alumno.class)
				.addAnnotatedClass(Matricula.class)
				.buildSessionFactory();
		
		//Inicio de la sesión (conexion)
		Session miSession = miSF.openSession();
			
		//Inserción de datos
		try {
		
			Alumno alumno1 = new Alumno("Jesus", "Gil y Gil", "696969696");
			Matricula matricula1 = new Matricula("000000001A", "2 DAM", "Trial");
			
			Alumno alumno2 = new Alumno("Paco", "Umbral", "666000666");
			Matricula matricula2 = new Matricula("000LIBRO00", "Todos los cursos", "Biblioteca");
			
			Alumno alumno3 = new Alumno("Jose", "Toxeiro", "621321321");
			Matricula matricula3 = new Matricula("COLACAO003", "Cocina", "Batidos chocolateados");
			
			//Asociación de los objetos
			alumno1.setMatricula(matricula1);
			alumno2.setMatricula(matricula2);
			alumno3.setMatricula(matricula3);
			
			//Inicio de la sesión
			miSession.beginTransaction();
			
			//Guardado de los alumnos
			miSession.save(alumno1);
			miSession.save(alumno2);
			miSession.save(alumno3);
			
			//Finalización del guardado
			miSession.getTransaction().commit();
			
			//Control de errores
			System.out.println("Alumnos insertados correctamente en la BBDD.");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			miSession.close();
			miSF.close();
			
		}
		
	}

}