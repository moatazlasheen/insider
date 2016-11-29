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
@Table(name = "material_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialType.findAll", query = "SELECT m FROM MaterialType m")
    , @NamedQuery(name = "MaterialType.findByMaterialTypeId", query = "SELECT m FROM MaterialType m WHERE m.materialTypeId = :materialTypeId")
    , @NamedQuery(name = "MaterialType.findByItemTypeDesc", query = "SELECT m FROM MaterialType m WHERE m.itemTypeDesc = :itemTypeDesc")})
public class MaterialType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "material_type_id")
    private Integer materialTypeId;
    @Column(name = "item_type_desc")
    private String itemTypeDesc;

    public MaterialType() {
    }

    public MaterialType(Integer materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public Integer getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(Integer materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public String getItemTypeDesc() {
        return itemTypeDesc;
    }

    public void setItemTypeDesc(String itemTypeDesc) {
        this.itemTypeDesc = itemTypeDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materialTypeId != null ? materialTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialType)) {
            return false;
        }
        MaterialType other = (MaterialType) object;
        if ((this.materialTypeId == null && other.materialTypeId != null) || (this.materialTypeId != null && !this.materialTypeId.equals(other.materialTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MaterialType[ materialTypeId=" + materialTypeId + " ]";
    }

}
