/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelo.Carro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Isadora
 */
public class CarroDao {

    static SessionFactory sessFact = HibernateUtil.getSessionFactory();

    public void Salvar(Carro carro) {
        Session sessao = sessFact.getCurrentSession();
        Transaction trasacao = sessao.beginTransaction();;
        try {

            sessao.save(carro);
            trasacao.commit();
            System.out.println("salvando carro");
        } catch (RuntimeException ex) {
            if (trasacao != null) {
                trasacao.rollback();
            }
        } finally {
            sessao.close();
        }

    }

    public ObservableList<Carro> listarCarro() {
        Session sessao = sessFact.getCurrentSession();
        Transaction trasacao = null;
        trasacao = sessao.beginTransaction();
        ObservableList<Carro> list = FXCollections.observableArrayList();
        try {

            List<Carro> eList = sessao.createCriteria(Carro.class).list();
            for (Carro ent : eList) {
                list.add(ent);

            }

            System.out.println("-------List de usuario---------");

        } catch (Exception e) {
            if (trasacao != null) {
                trasacao.rollback();
            }
        } finally {
            sessao.close();
        }

        return list;
    }

    public Carro carregarId(Integer idCarro) {
        Session sessao = sessFact.openSession();
        Transaction trasacao = sessao.beginTransaction();
Carro car = new Carro();
        try {
            car = (Carro) sessao.get(Carro.class, idCarro);
            trasacao.commit();
            System.out.println("-------carregando carro por id---------");
        }catch (RuntimeException ex) {
            if (trasacao != null) {
                trasacao.rollback();
            }
        } finally {
            if (sessao != null) {
                sessao.close();
            }
            
    }
        return car;
}
}