/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ramy
 */
@Entity
@Table(catalog = "insider3_insider360", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"gener_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gener.findAll", query = "SELECT g FROM Gener g"),
    @NamedQuery(name = "Gener.findByGenerId", query = "SELECT g FROM Gener g WHERE g.generId = :generId"),
    @NamedQuery(name = "Gener.findByGenerCode", query = "SELECT g FROM Gener g WHERE g.generCode = :generCode"),
    @NamedQuery(name = "Gener.findByGenerDesc", query = "SELECT g FROM Gener g WHERE g.generDesc = :generDesc")})
public class Gener implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gener_id", nullable = false)
    private Integer generId;
    @Column(name = "gener_code", length = 20)
    private String generCode;
    @Column(name = "gener_desc", length = 150)
    private String generDesc;

    public Gener() {
    }

    public Gener(Integer generId) {
        this.generId = generId;
    }

    public Integer getGenerId() {
        return generId;
    }

    public void setGenerId(Integer generId) {
        this.generId = generId;
    }

    public String getGenerCode() {
        return generCode;
    }

    public void setGenerCode(String generCode) {
        this.generCode = generCode;
    }

    public String getGenerDesc() {
        return generDesc;
    }

    public void setGenerDesc(String generDesc) {
        this.generDesc = generDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (generId != null ? generId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gener)) {
            return false;
        }
        Gener other = (Gener) object;
        if ((this.generId == null && other.generId != null) || (this.generId != null && !this.generId.equals(other.generId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Gener[ generId=" + generId + " ]";
    }
    
}
