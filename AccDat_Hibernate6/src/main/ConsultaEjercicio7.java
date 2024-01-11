package main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelos.*;

public class ConsultaEjercicio7 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Inicio de los elementos de conexion
		SessionFactory miSF = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Categorias.class)
				.addAnnotatedClass(Productos.class)
				.buildSessionFactory();
		Session miSession = miSF.openSession();
		
		try {

			//C�digo de consulta HQL
			Query query = miSession.createQuery("SELECT p.categorias,COUNT(p.id),AVG(p.precioUnidad) FROM Productos p "
					+ "INNER JOIN p.categorias GROUP BY p.categorias");
	
			//Lista de objetos donde se guardar� el resultado de la consulta anterior
			List<Object[]> lista = query.list();
			
			//Cabecera mostrada por pantalla
			System.out.println("\nEjercicio 7.- Cu�ntos productos hay de cada categor�a y el precio medio.\n");
	
			//Para cada elemento de la lista...
			for (Object[] elem : lista) {
				
				//Obtenemos los objetos que nos interesan y los mostramos por pantalla
				Categorias cat = (Categorias) elem[0];
				long contador = (long) elem[1];
				double precMedio = (double) elem[2];
				
				System.out.println("CATEGORIA: " + cat.getCategoria());
				System.out.println("NUM. PRODUCTOS: " + contador);
				System.out.println("PRECIO MEDIO: " + precMedio);
				
				System.out.println("-------------------------------------------------------------------------------");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			//Cerramos la conexi�n
			miSession.close();
			miSF.close();
		}
			
	
	} //Fin del main
	
} //Fin de la clase



