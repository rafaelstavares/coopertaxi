package util;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author PC-ASUS
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
            try {
            	Configuration cfg = new Configuration().configure("/resources/hibernate.cfg.xml");        	
            	StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            	sb.applySettings(cfg.getProperties());
            	StandardServiceRegistry standardServiceRegistry = sb.build();           	
            	sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);      	
            } catch (Throwable th) {
                    System.err.println("Enitial SessionFactory creation failed" + th);
                    throw new ExceptionInInitializerError(th);
            }
    }
    public static SessionFactory getSessionFactory() {
            return sessionFactory;
    }
}
