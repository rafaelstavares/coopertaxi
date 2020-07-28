/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.CarroDao.sessFact;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelo.Carro;
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
     
  public List<Carro> listarCotas() {
        Session sessao = sessFact.getCurrentSession();
        Transaction trasacao = null;
        trasacao = sessao.beginTransaction();
        List<Carro> list = FXCollections.observableArrayList();
        try {

            List<Carro> eList = sessao.createCriteria(Carro.class).list();
            for (Carro ent : eList) {
                list.add(ent);

            }

            System.out.println("-------List de carros com Cotas---------");

        } catch (Exception e) {
            if (trasacao != null) {
                trasacao.rollback();
            }
        } finally {
            sessao.close();
        }

        return list;
    }
  public ObservableList<Cota> listarCotasData() {
        Session sessao = sessFact.getCurrentSession();
        Transaction trasacao = null;
        trasacao = sessao.beginTransaction();
        ObservableList<Cota> list = FXCollections.observableArrayList();
        try {

            List<Cota> eList = sessao.createCriteria(Cota.class).list();
            for (Cota ent : eList) {
                list.add(ent);

            }

            System.out.println("-------List de Cotas e datas---------");

        } catch (Exception e) {
            if (trasacao != null) {
                trasacao.rollback();
            }
        } finally {
            sessao.close();
        }

        return list;
    }
  
  public List<Cota> allListarCotas() {
        Session sessao = sessFact.getCurrentSession();
        Transaction trasacao = null;
        trasacao = sessao.beginTransaction();
        ObservableList<Cota> list = FXCollections.observableArrayList();
        try {

            List<Cota> eList = sessao.createCriteria(Cota.class).list();
            for (Cota ent : eList) {
                list.add(ent);

            }

            System.out.println("-------List de Cotas---------");

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
