package Main;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="matricula")
public class Matricula {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="num_matricula")
	private String numMatricula;
	@Column(name="curso")
	private String curso;
	@Column(name="grupo")
	private String grupo;
	
	@OneToOne(mappedBy="matricula", cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private Alumno alumno;
	
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

	public String getWeb() {
		return numMatricula;
	}

	public void setWeb(String numMatricula) {
		this.numMatricula = numMatricula;
	}

	public String getTelefono() {
		return curso;
	}

	public void setTelefono(String curso) {
		this.curso = curso;
	}

	public String getComentarios() {
		return grupo;
	}

	public void setComentarios(String comentarios) {
		this.grupo = comentarios;
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
