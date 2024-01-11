package main;

import java.util.GregorianCalendar;

import javax.persistence.*;

@Entity
@Table(name="pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="fecha")
	private GregorianCalendar fecha;
	@Column(name="forma_pago")
	private String formaPago;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

	//Constructor por defecto
	public Pedido() {
	}
	
	//Constructor con fecha
	public Pedido(GregorianCalendar gregorianCalendar, String formaPago, Cliente cliente) {
		super();
		this.fecha = gregorianCalendar;
		this.formaPago = formaPago;
		this.cliente = cliente;
	}
	
} 