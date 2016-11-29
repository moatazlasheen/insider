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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author mrnull <ahmadmoawad3@gmail.com>
 */
@Entity
@Table(name = "gener_materials")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenerMaterials.findAll", query = "SELECT g FROM GenerMaterials g")
    , @NamedQuery(name = "GenerMaterials.findByGenerId", query = "SELECT g FROM GenerMaterials g WHERE g.generMaterialsPK.generId = :generId")
    , @NamedQuery(name = "GenerMaterials.findByMaterialId", query = "SELECT g FROM GenerMaterials g WHERE g.generMaterialsPK.materialId = :materialId")
    , @NamedQuery(name = "GenerMaterials.findByDescription", query = "SELECT g FROM GenerMaterials g WHERE g.description = :description")})
public class GenerMaterials implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GenerMaterialsPK generMaterialsPK;
    @Column(name = "description")
    private String description;

    public GenerMaterials() {
    }

    public GenerMaterials(GenerMaterialsPK generMaterialsPK) {
        this.generMaterialsPK = generMaterialsPK;
    }

    public GenerMaterials(int generId, int materialId) {
        this.generMaterialsPK = new GenerMaterialsPK(generId, materialId);
    }

    public GenerMaterialsPK getGenerMaterialsPK() {
        return generMaterialsPK;
    }

    public void setGenerMaterialsPK(GenerMaterialsPK generMaterialsPK) {
        this.generMaterialsPK = generMaterialsPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (generMaterialsPK != null ? generMaterialsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenerMaterials)) {
            return false;
        }
        GenerMaterials other = (GenerMaterials) object;
        if ((this.generMaterialsPK == null && other.generMaterialsPK != null) || (this.generMaterialsPK != null && !this.generMaterialsPK.equals(other.generMaterialsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.GenerMaterials[ generMaterialsPK=" + generMaterialsPK + " ]";
    }

}
