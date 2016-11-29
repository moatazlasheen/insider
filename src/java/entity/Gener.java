/*
GPL * Copyright (C) 2016 mrnull <ahmadmoawad3@gmail.com>
GPL *
GPL * This program is free software; you can redistribute it and/or
GPL * modify it under the terms of the GNU General Public License
GPL * as published by the Free Software Foundation; either version 2
GPL * of the License, or (at your option) any later version.
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author mrnull <ahmadmoawad3@gmail.com>
 */
@Entity
@Table(name = "GENER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gener.findAll", query = "SELECT g FROM Gener g")
    , @NamedQuery(name = "Gener.findByGenerId", query = "SELECT g FROM Gener g WHERE g.generId = :generId")
    , @NamedQuery(name = "Gener.findByGenerCode", query = "SELECT g FROM Gener g WHERE g.generCode = :generCode")
    , @NamedQuery(name = "Gener.findByGenerDesc", query = "SELECT g FROM Gener g WHERE g.generDesc = :generDesc")})
public class Gener implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gener_id")
    private Integer generId;
    @Column(name = "gener_code")
    private String generCode;
    @Column(name = "gener_desc")
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
