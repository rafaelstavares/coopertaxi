/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author PC-ASUS
 */
public class UsuarioDao {
SessionFactory sessFact = HibernateUtil.getSessionFactory();



    public void Salvar(Usuario usuario) {
       Session sessao = sessFact.getCurrentSession();
        Transaction trasacao = null;
        try {
            trasacao = sessao.beginTransaction();
            sessao.save(usuario);
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
