package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static Cliente cliente1 = new Cliente("Perico", "el de los Palotes", "C/ Falsa, 123",TiposBasicos.Persona);
	public static Cliente cliente2 = new Cliente("Explotadores S.A.", "", "Fake Street, 123",TiposBasicos.Empresa);
	public static Cliente cliente3 = new Cliente("Gobierno de España", "", "Moncloa s/n",TiposBasicos.Sociedad);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Iniciamos configuración para preparar hibernate para actuar
		SessionFactory miSF = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				
				.buildSessionFactory();
		
		//Abrimos sesión en hibernate
		Session miSession = miSF.openSession();
		
		try {
		//Arrancamos la conexión
		miSession.beginTransaction();
		
		//Guardamos el cliente en la memoria
		miSession.save(cliente1);
		miSession.save(cliente2);
		miSession.save(cliente3);
		
		//Realizamos control de errores
		System.out.println("Clientes guardados correctamente en la Base de Datos");
		
		//Actualizamos la Base de Datos con los datos en memoria
		miSession.getTransaction().commit();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		
		//Cerramos la sesión de Hibernate
		miSF.close();
		miSession.close();
		}
	}

}
