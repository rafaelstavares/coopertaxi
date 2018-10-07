/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package img;

import modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author PC-ASUS
 */
public class teste {

    public static void main(String[] args) {

        SessionFactory sessFact = HibernateUtil.getSessionFactory();

       
        try {
             Usuario us = new Usuario();
            Session session = sessFact.getCurrentSession();
            us.setNome("rafa2");
            us.setSenha("admin");
            us.setUsuario("ggg");
            session.beginTransaction();
            session.save(us);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("errro " + e);
        }

    }
}
