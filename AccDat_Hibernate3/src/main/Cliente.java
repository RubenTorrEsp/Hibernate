package main;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellidos")
	private String apellidos;
	@Column(name="direccion")
	private String direccion;
		
	@OneToMany(mappedBy="cliente", cascade= {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	private Set<Pedido> pedidos;
		

	//Constructor por defecto
	public Cliente() {
	}

	//Constructor con par�metros
	public Cliente(String nombre, String apellidos, String direccion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
	}
		
	/**
	 * M�todo para agregar pedidos a la lista de pedidos de un cliente
	 * @param miPedido
	 */
	public void agregarPedidos(Pedido miPedido) {
		pedidos.add(miPedido);
	}


	/**
	 * M�todo para designar una lista de pedidos a un cliente
	 * @param pedidos
	 */
	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}