/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author PC-ASUS
 */
@Entity
@Table(name = "cota")
public class Cota implements Serializable {

    public Cota(Integer idCota, float valorCota, Date dataCota, Carro carro) {
        this.idCota = idCota;
        this.valorCota = valorCota;
        this.dataCota = dataCota;
        this.carro = carro;
    }

    public Cota() {
    }

    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idCota;
    float valorCota;
    @Basic
    @Temporal(TemporalType.DATE)
    Date dataCota;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "carro_idcarro", nullable = true)
    Carro carro;

    public Integer getIdCota() {
        return idCota;
    }

    public void setIdCota(Integer idCota) {
        this.idCota = idCota;
    }

    public float getValorCota() {
        return valorCota;
    }

    public void setValorCota(float valorCota) {
        this.valorCota = valorCota;
    }

    public Date getDataCota() {
        return dataCota;
    }

    public void setDataCota(Date dataCota) {
        this.dataCota = dataCota;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idCota);
        hash = 29 * hash + Float.floatToIntBits(this.valorCota);
        hash = 29 * hash + Objects.hashCode(this.dataCota);
        hash = 29 * hash + Objects.hashCode(this.carro);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cota other = (Cota) obj;
        if (Float.floatToIntBits(this.valorCota) != Float.floatToIntBits(other.valorCota)) {
            return false;
        }
        if (!Objects.equals(this.idCota, other.idCota)) {
            return false;
        }
        if (!Objects.equals(this.dataCota, other.dataCota)) {
            return false;
        }
        if (!Objects.equals(this.carro, other.carro)) {
            return false;
        }
        return true;
    }
    
}
