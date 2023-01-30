package utiles;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {

	private static final SessionFactory sessionFactory;
	/*
	 * Creamos bloque est�tico donde cargaremos el fichero de configuraci�n
	 * hibernate.cfg.xml e inicializamos Hibernate
	 */
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();

		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
