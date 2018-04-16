package pe.edu.cibertec.proyemp.convertDate;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;


//CLASE PARA CONVERTIR EL FORMATO DE FECHA
public class UtilFormat {

	public static Date getFecha(LocalDate localdate) {

		return Date.from(localdate.atStartOfDay(
				ZoneId.systemDefault()).toInstant());
	}
	
	//SE REFACTORIZA CODIGO PARA QUE ESTA CLASE CONTENGA LOS 2 METODOS
	public static Date getFecha(int year, Month month, int day){
		
		LocalDate fecha = LocalDate.of(year, month, day);
		return getFecha(fecha);
	}

}
