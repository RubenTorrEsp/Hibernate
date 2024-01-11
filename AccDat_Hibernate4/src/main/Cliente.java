package main;

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
	
	@Enumerated(EnumType.STRING)
	private TiposBasicos tipoCliente;
	
		
	//Constructor por defecto
	public Cliente() {
	}

	//Constructor con parámetros
	public Cliente(String nombre, String apellidos, String direccion, TiposBasicos tipoCliente) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.tipoCliente = tipoCliente;
	}
		
}