package main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelos.*;

public class ConsultaEjercicio9 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Inicio de los elementos de conexion
		SessionFactory miSF = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Clientes.class)
				.addAnnotatedClass(Detalles.class)
				.addAnnotatedClass(Pedidos.class)
				.addAnnotatedClass(Productos.class)
				.buildSessionFactory();
		Session miSession = miSF.openSession();
		
		try {
			
			//Código de consulta HQL
			Query query = miSession.createQuery("SELECT DISTINCT d.id,d.productos,d.pedidos FROM Detalles d INNER JOIN d.productos INNER JOIN d.pedidos INNER JOIN d.pedidos.clientes "
					+ "WHERE d.productos.producto LIKE '%queso%'"
					+ "AND d.pedidos.fechaEntrega BETWEEN 1997-07-01 AND 1997-07-31");

			//Lista de objetos donde se guardará el resultado de la consulta anterior
			List<Object[]> lista = query.list();
			
			//Cabecera mostrada por pantalla
			System.out.println("\nEjercicio 9.- Clientes que pidieron queso en julio de 1997.\n");
	
			//Para cada elemento de la lista...
			for (Object[] elem : lista) {
				
				//Obtenemos los objetos que nos interesan y los mostramos por pantalla
				Pedidos ped = (Pedidos) elem[2];
				
				System.out.println("Cliente: " + ped.getClientes().getEmpresa());
				
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



