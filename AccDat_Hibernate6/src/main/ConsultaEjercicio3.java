package main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelos.*;

public class ConsultaEjercicio3 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Inicio de los elementos de conexion
		SessionFactory miSF = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Detalles.class)
				.addAnnotatedClass(Pedidos.class)
				.addAnnotatedClass(Productos.class)
				.buildSessionFactory();
		Session miSession = miSF.openSession();
		
		try {

			//Código de consulta HQL
			Query query = miSession.createQuery("FROM Detalles d "
					+ "INNER JOIN d.pedidos as p "
					+ "INNER JOIN d.productos as c "
					+ "WHERE p.id IN (10285,10298)");
	
			//Lista de objetos donde se guardará el resultado de la consulta anterior
			List<Object[]> lista = query.list();
			
			//Cabecera mostrada por pantalla
			System.out.println("\nEjercicio 3.- Mostrar fecha del pedido, cantidad y el nombre producto, y el código del pedido para los códigos de pedido 10285 o 10298.\n");
	
			//Para cada elemento de la lista...
			for (Object[] elem : lista) {
				
				//Obtenemos los objetos que nos interesan y los mostramos por pantalla
				Detalles det = (Detalles) elem[0];
								
				System.out.println("NUM. PEDIDO: " + det.getPedidos().getId());
				System.out.println("FECHA: " + det.getPedidos().getFechaPedido());
				System.out.println("NOMBRE: " + det.getProductos().getProducto());
				System.out.println("CANTIDAD: " + det.getCantidad());
				
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



