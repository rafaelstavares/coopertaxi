/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Cota;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Isadora
 */
public class CotaDao {
    
     static SessionFactory sessFact = HibernateUtil.getSessionFactory();
     
     
    public void SalvarCota(Cota cota){
        Session sessao = sessFact.getCurrentSession();
        Transaction trasacao = sessao.beginTransaction();;
        try {

            sessao.save(cota);
            trasacao.commit();

        } catch (RuntimeException ex) {
            if (trasacao != null) {
                trasacao.rollback();
            }
        } finally {
            sessao.close();
        }

    } 
     
     
}
