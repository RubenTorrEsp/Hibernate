package Main;

import javax.persistence.*;

@Entity
@Table(name="superUsuario")
public class SuperUsuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdUser")
	private int idUser;
	@Column(name="Nombre")
	private String nombre;
	@Column(name="Apellidos")
	private String apellidos;
	@Column(name="User")
	private String user;
	
	
	//Constructor por defecto
	public SuperUsuario() {
	}

	//Constructor con parámetros
	public SuperUsuario(String nombre, String apellidos, String telefono) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.user = telefono;
	}

	
	//Getter y setter idUser
	public int getId() {
		return idUser;
	}

	public void setId(int id) {
		this.idUser = id;
	}

	
	//Getter y setter nombre
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	//Getter y setter apellidos
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	
	//Getter y setter direccion
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	
	/**
	 * Método para devolver en forma de línea de texto
	 * todos los parámetros
	 */
	@Override
	public String toString() {
		return "Alumno [id=" + idUser + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + user + "]";
	}

}
