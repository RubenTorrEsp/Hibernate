package main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Main {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		//Iniciamos configuración para preparar hibernate para actuar
		SessionFactory miSF = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Alumno.class)
				.addAnnotatedClass(Matricula.class)
				.buildSessionFactory();
		
		//Abrimos sesión en hibernate
		Session miSession = miSF.openSession();
		Query query = miSession.getNamedQuery("mostrarAlumnos");
		List<Alumno> listaAlumnos = query.list();
		for (Alumno alumno : listaAlumnos) {
			System.out.println(alumno.toString());
		}
	
	}

}
