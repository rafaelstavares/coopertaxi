/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    static SessionFactory sessFact = HibernateUtil.getSessionFactory();

    public void Salvar(Usuario usuario) {
        Session sessao = sessFact.getCurrentSession();
        Transaction trasacao = sessao.beginTransaction();;
        try {

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
        Transaction trasacao = sessao.beginTransaction();;
        try {

            sessao.delete(usuario);
            trasacao.commit();
            sessFact.close();
        } catch (RuntimeException ex) {
            if (trasacao != null) {
                trasacao.rollback();
            }
        } finally {
            sessFact.close();
        }

    }

    public Usuario carregarId(Integer idUsuario) {
        Session sessao = sessFact.openSession();
        Transaction trasacao = sessao.beginTransaction();
        Usuario user = new Usuario();
        try {

            user = (Usuario) sessao.get(Usuario.class, idUsuario);
            trasacao.commit();
            System.out.println("-------carregando por id---------");

        } catch (RuntimeException ex) {
            if (trasacao != null) {
                trasacao.rollback();
            }
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }

        return user;
    }

    public Usuario buscarPorLogin(String usuario) {
        Session sessao = sessFact.openSession();
        Transaction trasacao = sessao.beginTransaction();;
        Usuario user = null;
        try {

            String hql = "select u from Usuario u where u.usuario = :usuario";
            Query consulta = sessao.createQuery(hql);
            consulta.setString("usuario", usuario);
            user = (Usuario) consulta.uniqueResult();
            trasacao.commit();
            System.out.println("-------carregando por nonme usuario---------");

        } catch (Exception e) {
            if (trasacao != null) {
                trasacao.rollback();
            }
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }

        return user;
    }

    public ObservableList<Usuario> ListarUser() {
        Session sessao = sessFact.getCurrentSession();
        Transaction trasacao = null;
          trasacao = sessao.beginTransaction();
        ObservableList<Usuario> list = FXCollections.observableArrayList();;
        try {
          
            List<Usuario> eList = sessao.createCriteria(Usuario.class).list();
            for (Usuario ent : eList) {
                list.add(ent);

            }
           
        } catch (Exception e) {
            if (trasacao != null) {
                trasacao.rollback();
            }
        } finally {
            sessao.close();
        }

        return list;
    }

}
