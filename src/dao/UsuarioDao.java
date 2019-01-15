/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Usuario;
import org.hibernate.Query;
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

    public void deletar(Usuario usuario) {
        Session sessao = sessFact.getCurrentSession();
        Transaction trasacao = null;
        try {
            trasacao = sessao.beginTransaction();
            sessao.delete(usuario);
            trasacao.commit();
        } catch (RuntimeException ex) {
            if (trasacao != null) {
                trasacao.rollback();
            }
        } finally {
            sessao.close();
        }

    }

    public Usuario carregarId(Integer idUsuario) {
        Session sessao = sessFact.getCurrentSession();
        Transaction trasacao = null;
        Usuario user = null;
        try {
            trasacao = sessao.beginTransaction();
            user = (Usuario) sessao.get(Usuario.class, idUsuario);
        } catch (RuntimeException ex) {
            if (trasacao != null) {
                trasacao.rollback();
            }
        } finally {
            sessao.close();
        }

        return user;
    }

    public Usuario buscarPorLogin(String usuario) {
        Session sessao = sessFact.getCurrentSession();
        Transaction trasacao = null;
        trasacao = sessao.beginTransaction();
        String hql = "select u from Usuario u where u.usuario = :usuario";

        Query consulta = sessao.createQuery(hql);
        consulta.setString("usuario", usuario);
        return (Usuario) consulta.uniqueResult();
    }

}
