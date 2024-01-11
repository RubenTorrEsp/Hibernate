package main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelos.*;

public class ConsultaEjercicio8 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Inicio de los elementos de conexion
		SessionFactory miSF = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Categorias.class)
				.addAnnotatedClass(Detalles.class)
				.addAnnotatedClass(Pedidos.class)
				.addAnnotatedClass(Productos.class)
				.buildSessionFactory();
		Session miSession = miSF.openSession();
		
		try {

			//Código de consulta HQL
			Query query = miSession.createQuery("SELECT d.pedidos,d.productos FROM Detalles d "
					+ "INNER JOIN d.pedidos INNER JOIN d.productos WHERE d.productos.id IN "
					+ "(SELECT p.id FROM Productos p INNER JOIN p.categorias WHERE p.categorias.id IN (2,3))");
	
			//Lista de objetos donde se guardará el resultado de la consulta anterior
			List<Object[]> lista = query.list();
			
			//Cabecera mostrada por pantalla
			System.out.println("\nEjercicio 8.- Mostrar los pedidos que tienen productos en la categoría 2 o 3.\n");
	
			//Para cada elemento de la lista...
			for (Object[] elem : lista) {
				
				//Obtenemos los objetos que nos interesan y los mostramos por pantalla
				Pedidos ped = (Pedidos) elem[0];
							
				System.out.println("ID PEDIDO: " + ped.getId());
							
				System.out.println("-------------------------------------------------------------------------------");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			//Cerramos la conexión
			miSession.close();
			miSF.close();
		}
			
	
	} //Fin del main
	
} //Fin de la clase



