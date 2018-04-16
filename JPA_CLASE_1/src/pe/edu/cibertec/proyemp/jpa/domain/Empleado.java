package pe.edu.cibertec.proyemp.jpa.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity  //ENTIDAD
@Table(name="TB_EMPLEADO") //Se enlaza al nombre de la tabla de la BD


public class Empleado {

	@Id
	@GeneratedValue //Autogenerado
	@Column (name="Emp_id", nullable = false, unique=true)
	private Long id;

	@Column (name="Emp_nombre", nullable = false, length = 200)
	private String nombre;

	@ManyToOne  //Relacion Foranea en departamento
	@JoinColumn(name="Dep_id") // Como es llave foranea se tiene que entender la relacion 
	private Departamento departamento;
	
	@Column(name="EMP_SALARIO", precision=10, scale=2)
	private BigDecimal salario;
	

	@Column(name="EMP_FEC_ING")
	@Temporal(value = TemporalType.DATE)
	private Date fechaIngreso;
	
	@Column (name="EMP_ESTADO", columnDefinition ="CHAR(1)")
	private String estado;


	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	// Para solucionar el error se coloca un constructor vacio
	public Empleado() {
	}

	



	public Empleado(String nombre, Departamento departamento, BigDecimal salario, Date fechaIngreso) {
		super();
		this.nombre = nombre;
		this.departamento = departamento;
		this.salario = salario;
		this.fechaIngreso = fechaIngreso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", departamento=" + departamento + ", salario=" + salario
				+ ", fechaIngreso=" + fechaIngreso + ", estado=" + estado + "]";
	}

	

}
