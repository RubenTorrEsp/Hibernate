package main;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelos.*;

public class ConsultaEjercicio2 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Inicio de los elementos de conexion
		SessionFactory miSF = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Pedidos.class)
				.buildSessionFactory();
		Session miSession = miSF.openSession();
		
		try {

			//C�digo de consulta HQL
			Query query = miSession.createQuery("SELECT p.id,p.paisDestinatario,p.fechaPedido "
					+ "FROM Pedidos p WHERE year(p.fechaPedido)=1997 and month(p.fechaPedido)=5 order by p.fechaPedido");
	
			//Lista de objetos donde se guardar� el resultado de la consulta anterior
			List<Object[]> lista = query.list();
			
			//Cabecera mostrada por pantalla
			System.out.println("\nEjercicio 2.- Mostrar el n�mero de pedido y el pa�s del cliente de los pedidos de mayo del a�o 1997.\n");
	
			//Para cada elemento de la lista...
			for (Object[] elem : lista) {
				
				//Obtenemos los objetos que nos interesan y los mostramos por pantalla
				Integer ped = (Integer) elem[0];
				String pais = (String) elem[1];
				Date fecha = (Date) elem[2];
				
				System.out.println("NUM. PEDIDO: " + ped);
				System.out.println("PAIS: " + pais);
				System.out.println("FECHA: " + fecha);
				
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



