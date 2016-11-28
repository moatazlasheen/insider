/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ramy
 */
@Embeddable
public class GenerMaterialsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "gener_id", nullable = false)
    private int generId;
    @Basic(optional = false)
    @Column(name = "material_id", nullable = false)
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
