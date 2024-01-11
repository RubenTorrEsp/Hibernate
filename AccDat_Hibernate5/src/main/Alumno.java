package main;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Alumno implements Serializable {
	
	private int id;
	private String nombre;
	private String apellidos;
	private String telefono;
	
	private Matricula matricula;
	
	//Constructor por defecto
	public Alumno() {
	}

	//Constructor con parámetros
	public Alumno(String nombre, String apellidos, String telefono) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
	}

	//Getter y setter id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	//Getter y setter detalles de cliente
	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

		
	//Método para devolver en forma de línea de texto
	//todos los parámetros
	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + "]";
	}


}
