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
import javax.persistence.Embeddable;

/**
 * @author mrnull <ahmadmoawad3@gmail.com>
 */
@Embeddable
public class GenerMaterialsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "gener_id")
    private int generId;
    @Basic(optional = false)
    @Column(name = "material_id")
    private int materialId;

    public GenerMaterialsPK() {
    }

    public GenerMaterialsPK(int generId, int materialId) {
        this.generId = generId;
        this.materialId = materialId;
    }

    public int getGenerId() {
        return generId;
    }

    public void setGenerId(int generId) {
        this.generId = generId;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) generId;
        hash += (int) materialId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenerMaterialsPK)) {
            return false;
        }
        GenerMaterialsPK other = (GenerMaterialsPK) object;
        if (this.generId != other.generId) {
            return false;
        }
        if (this.materialId != other.materialId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.GenerMaterialsPK[ generId=" + generId + ", materialId=" + materialId + " ]";
    }

}
