/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author PC-ASUS
 */
@Entity
@Table(name = "carroOficina")
public class CarroOficina {
    @Id
    @Column(name = "idCarroOficina")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idCarroOficina;
    
}
