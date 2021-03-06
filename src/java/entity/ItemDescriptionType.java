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
@Table(name = "item_description_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemDescriptionType.findAll", query = "SELECT i FROM ItemDescriptionType i")
    , @NamedQuery(name = "ItemDescriptionType.findByItemTypeId", query = "SELECT i FROM ItemDescriptionType i WHERE i.itemTypeId = :itemTypeId")
    , @NamedQuery(name = "ItemDescriptionType.findByMaterialTypeId", query = "SELECT i FROM ItemDescriptionType i WHERE i.materialTypeId = :materialTypeId")
    , @NamedQuery(name = "ItemDescriptionType.findByMaterialCategoryId", query = "SELECT i FROM ItemDescriptionType i WHERE i.materialCategoryId = :materialCategoryId")})
public class ItemDescriptionType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "item_type_id")
    private Integer itemTypeId;
    @Basic(optional = false)
    @Column(name = "material_type_id")
    private int materialTypeId;
    @Basic(optional = false)
    @Column(name = "material_category_id")
    private int materialCategoryId;

    public ItemDescriptionType() {
    }

    public ItemDescriptionType(Integer itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public ItemDescriptionType(Integer itemTypeId, int materialTypeId, int materialCategoryId) {
        this.itemTypeId = itemTypeId;
        this.materialTypeId = materialTypeId;
        this.materialCategoryId = materialCategoryId;
    }

    public ItemDescriptionType(int materialCategoryId, int materialTypeId) {
        this.materialCategoryId = materialCategoryId;
        this.materialTypeId = materialTypeId;
    }

    public Integer getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Integer itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public int getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(int materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public int getMaterialCategoryId() {
        return materialCategoryId;
    }

    public void setMaterialCategoryId(int materialCategoryId) {
        this.materialCategoryId = materialCategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemTypeId != null ? itemTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemDescriptionType)) {
            return false;
        }
        ItemDescriptionType other = (ItemDescriptionType) object;
        if ((this.itemTypeId == null && other.itemTypeId != null) || (this.itemTypeId != null && !this.itemTypeId.equals(other.itemTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ItemDescriptionType[ itemTypeId=" + itemTypeId + " ]";
    }

}
