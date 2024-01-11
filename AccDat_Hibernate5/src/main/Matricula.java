package main;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Matricula implements Serializable{
	
	private int id;
	private String numMatricula;
	private String curso;
	private String grupo;
	
	private Alumno alumno;
	
	public String getNumMatricula() {
		return numMatricula;
	}

	public void setNumMatricula(String numMatricula) {
		this.numMatricula = numMatricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	//Constructor sin parámetros
	public Matricula() {
	}

	public Matricula(String numMatricula, String curso, String grupo) {
		super();
		this.numMatricula = numMatricula;
		this.curso = curso;
		this.grupo = grupo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	
	
	@Override
	public String toString() {
		return "DetallesCliente [id=" + id + ", web=" + numMatricula + ", telefono=" + curso + ", comentarios=" + grupo
				+ ", alumno=" + alumno + "]";
	}

	
	
}
