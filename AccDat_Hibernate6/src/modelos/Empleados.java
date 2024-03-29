package modelos;
// Generated 30 ene. 2021 12:38:12 by Hibernate Tools 5.4.21.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Empleados generated by hbm2java
 */
public class Empleados implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Empleados empleados;
	private String apellidos;
	private String nombre;
	private String cargo;
	private String tratamiento;
	private Date fechaNacimiento;
	private Date fechaContratacion;
	private String direccion;
	private String ciudad;
	private String region;
	private String cp;
	private String pais;
	private String telefonoDomicilio;
	private String extension;
	private String notas;
	@SuppressWarnings("rawtypes")
	private Set pedidoses = new HashSet(0);
	@SuppressWarnings("rawtypes")
	private Set empleadoses = new HashSet(0);

	public Empleados() {
	}

	public Empleados(String apellidos, String nombre) {
		this.apellidos = apellidos;
		this.nombre = nombre;
	}

	@SuppressWarnings("rawtypes")
	public Empleados(Empleados empleados, String apellidos, String nombre, String cargo, String tratamiento,
			Date fechaNacimiento, Date fechaContratacion, String direccion, String ciudad, String region, String cp,
			String pais, String telefonoDomicilio, String extension, String notas, Set pedidoses, Set empleadoses) {
		this.empleados = empleados;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.cargo = cargo;
		this.tratamiento = tratamiento;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaContratacion = fechaContratacion;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.region = region;
		this.cp = cp;
		this.pais = pais;
		this.telefonoDomicilio = telefonoDomicilio;
		this.extension = extension;
		this.notas = notas;
		this.pedidoses = pedidoses;
		this.empleadoses = empleadoses;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Empleados getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(Empleados empleados) {
		this.empleados = empleados;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTratamiento() {
		return this.tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaContratacion() {
		return this.fechaContratacion;
	}

	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCp() {
		return this.cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTelefonoDomicilio() {
		return this.telefonoDomicilio;
	}

	public void setTelefonoDomicilio(String telefonoDomicilio) {
		this.telefonoDomicilio = telefonoDomicilio;
	}

	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getNotas() {
		return this.notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	@SuppressWarnings("rawtypes")
	public Set getPedidoses() {
		return this.pedidoses;
	}

	@SuppressWarnings("rawtypes")
	public void setPedidoses(Set pedidoses) {
		this.pedidoses = pedidoses;
	}

	@SuppressWarnings("rawtypes")
	public Set getEmpleadoses() {
		return this.empleadoses;
	}

	@SuppressWarnings("rawtypes")
	public void setEmpleadoses(Set empleadoses) {
		this.empleadoses = empleadoses;
	}

}
