package ejercicios;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import clases.Departamento;
import clases.Empleado;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import utiles.SessionFactoryUtil;

public class Principal {
	public static void main(String[] args) throws SecurityException {
		
		
		
		SessionFactory s= new SessionFactoryUtil().getSessionFactory();
		Session sesion= s.openSession();
		Transaction t = (Transaction) sesion.beginTransaction();
		
		try {
			
			
			Empleado nuevo= new Empleado();
			
			BigDecimal salario= new BigDecimal(250);
			nuevo.setNumEmpleado(1);
			nuevo.setNombre("PepeLuis");
			nuevo.setApellido("Garcia");
			nuevo.setFechaAlta(Date.valueOf(LocalDate.of(2023, 1, 1)));
			nuevo.setSalario(salario);
			
			
			Departamento d= new Departamento();
			d= sesion.load(Departamento.class, 1);
			nuevo.setDepartamento(d);
			
			sesion.saveOrUpdate(nuevo);

			System.out.println("OKI DOKI");
			
			t.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("Error escrito por mi");
			if(t!=null) {
				t.rollback();
				
			}
		}
		finally {
			sesion.close();
		}
	}
	
	

}
