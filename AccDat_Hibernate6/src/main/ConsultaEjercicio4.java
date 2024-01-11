package main;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelos.*;

public class ConsultaEjercicio4 {

	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Inicio de los elementos de conexion
		SessionFactory miSF = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Detalles.class)
				.addAnnotatedClass(Pedidos.class)
				.buildSessionFactory();
		Session miSession = miSF.openSession();
		
		try {

			//Código de consulta HQL
			Query query = miSession.createQuery("SELECT d.pedidos, sum(d.cantidad * d.precioUnidad * (1-d.descuento)) "
					+ "FROM Detalles d INNER JOIN d.pedidos GROUP BY year(d.pedidos.fechaPedido),month(d.pedidos.fechaPedido)");
	
			//Lista de objetos donde se guardará el resultado de la consulta anterior
			List<Object[]> lista = query.list();
			
			//Cabecera mostrada por pantalla
			System.out.println("\nEjercicio 4.- ¿Cuánto se factura cada mes? Mostrar el año, el mes y el total.\n");
	
			//Para cada elemento de la lista...
			for (Object[] elem : lista) {
				
				//Obtenemos los objetos que nos interesan y los mostramos por pantalla
				Pedidos ped = (Pedidos) elem[0];
				double total = (double) elem[1];
				
				//Creamos un objeto de la clase Calendar para mostrar los elementos de la fecha individualmente
				Date year = (Date) ped.getFechaPedido();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(year);
				
				System.out.println("FECHA: " + calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH));
				System.out.println("TOTAL: " + total + "€");
				
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



