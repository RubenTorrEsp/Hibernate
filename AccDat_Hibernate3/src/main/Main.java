package main;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static Cliente cliente1 = new Cliente("Perico", "el de los Palotes", "C/ Falsa, 123");
	public static Set<Pedido> listaPedidos = new HashSet<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creamos pedidos y los añadimos a la lista de pedidos
		listaPedidos.add(new Pedido(new GregorianCalendar(2021,01,07),"Efectivo",cliente1));
		listaPedidos.add(new Pedido(new GregorianCalendar(2020,12,03),"Tarjeta",cliente1));
		listaPedidos.add(new Pedido(new GregorianCalendar(2019,07,06),"Contra Reembolso",cliente1));
		
		//Asignamos la lista de pedidos al cliente
		cliente1.setPedidos(listaPedidos);
		
		//Iniciamos configuración para preparar hibernate para actuar
		SessionFactory miSF = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(Pedido.class)
				.buildSessionFactory();
		
		//Abrimos sesión en hibernate
		Session miSession = miSF.openSession();
		
		//Arrancamos la conexión
		miSession.beginTransaction();
		
		//Guardamos el cliente en la memoria
		miSession.save(cliente1);
		
		//Realizamos control de errores
		System.out.println("Cliente guardado correctamente en la Base de Datos");
		
		//Actualizamos la Base de Datos con los datos en memoria
		miSession.getTransaction().commit();
		
		//Cerramos la sesión de Hibernate
		miSF.close();
		miSession.close();
		
	}

}
