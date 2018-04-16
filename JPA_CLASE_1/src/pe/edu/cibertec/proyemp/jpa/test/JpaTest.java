package pe.edu.cibertec.proyemp.jpa.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import pe.edu.cibertec.proyemp.convertDate.UtilFormat;
import pe.edu.cibertec.proyemp.jpa.domain.Departamento;
import pe.edu.cibertec.proyemp.jpa.domain.Empleado;

public class JpaTest {

	private EntityManager manager;

	// Inyeccion de dependencias con Constructor
	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	public static void main(String[] args) {

		// Utilizamos patron factory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit1");

		// Obtenemos el EntityManager
		EntityManager em = factory.createEntityManager();

		JpaTest test = new JpaTest(em);

		// definimos la transaccion
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		// insert, update y delete
		test.crearEmpleados();

		tx.commit();

		test.listarEmpleados();
		
		test.obtenerEmpleadoForId(new Long(1));
		
		
	}

	private void obtenerEmpleadoForId(Long id) {
		
		
		//HAY UNA TERCERA FORMA Y ES MEJOR
		//YA QUE PERMITE IDENTIFICAR CADA PARAMETRO
		Empleado emp = manager.createQuery("select e from Empleado e where e.id= :myId" , Empleado.class)
				.setParameter("myId", id)
				.getSingleResult();
		
	
		System.out.println(emp);
		//1.where e.id=?" + id
		
		//Se utiliza mayormente la segunda por temas de segura y para evitar
		// Inyeccion SQL
		//2.where e.id =?
	}

	private void listarEmpleados() {
		
		String jql = "From Empleado";
		
		List<Empleado> emp = 
				manager.createQuery(jql, Empleado.class).getResultList();
		for (Empleado empleado: emp){
			System.out.println(empleado.toString());
		}
		
		
	
	}
	
	


	private void crearEmpleados() {
		Departamento lima = new Departamento("Lima");
		manager.persist(lima);

		Departamento Cuzco = new Departamento("Cuzco");
		manager.persist(Cuzco);

		// Se agregan 4 empleados

	
		
		
		Empleado emp = new Empleado("Cristhian",Cuzco,new BigDecimal(8741.51),UtilFormat.getFecha(2012,Month.AUGUST,25));


		Empleado emp2 = new Empleado("Luis",lima,new BigDecimal(9154.51),UtilFormat.getFecha(20, Month.AUGUST, 30));

		Empleado emp3 = new Empleado("Doris",lima,new BigDecimal(9154.51),UtilFormat.getFecha(20, Month.JANUARY, 29));
		Empleado emp4 = new Empleado("Allison",lima,new BigDecimal(9154.51),UtilFormat.getFecha(20, Month.JUNE, 14));
		

		// Para ingresarlos a la base d edatos llamamos a nuestro
		// manager persist

		manager.persist(emp);

		manager.persist(emp2);
		
		manager.persist(emp3);

		manager.persist(emp4);
		// lima.setNombre("Lima");

	}

}
