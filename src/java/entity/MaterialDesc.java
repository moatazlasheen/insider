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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author elsaidel
 */
@Entity
@Table(name = "material_desc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialDesc.findAll", query = "SELECT m FROM MaterialDesc m"),
    @NamedQuery(name = "MaterialDesc.findByMaterialId", query = "SELECT m FROM MaterialDesc m WHERE m.materialId = :materialId"),
    @NamedQuery(name = "MaterialDesc.findByItemCode", query = "SELECT m FROM MaterialDesc m WHERE m.itemCode = :itemCode"),
    @NamedQuery(name = "MaterialDesc.findByMaterialType", query = "SELECT m FROM MaterialDesc m WHERE m.materialType = :materialType"),
    @NamedQuery(name = "MaterialDesc.findByUnitId", query = "SELECT m FROM MaterialDesc m WHERE m.unitId = :unitId"),
    @NamedQuery(name = "MaterialDesc.findByGenerId", query = "SELECT m FROM MaterialDesc m WHERE m.generId = :generId")})
public class MaterialDesc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "material_id")
    private Integer materialId;
    @Basic(optional = false)
    @Column(name = "item_code")
    private int itemCode;
    @Basic(optional = false)
    @Column(name = "material_type")
    private int materialType;
    @Basic(optional = false)
    @Column(name = "unit_id")
    private int unitId;
    @Lob
    @Column(name = "pic")
    private byte[] pic;
    @Basic(optional = false)
    @Column(name = "gener_id")
    private int generId;

    public MaterialDesc() {
    }

    public MaterialDesc(Integer materialId) {
        this.materialId = materialId;
    }

    public MaterialDesc(Integer materialId, int itemCode, int materialType, int unitId, int generId) {
        this.materialId = materialId;
        this.itemCode = itemCode;
        this.materialType = materialType;
        this.unitId = unitId;
        this.generId = generId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public int getMaterialType() {
        return materialType;
    }

    public void setMaterialType(int materialType) {
        this.materialType = materialType;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public int getGenerId() {
        return generId;
    }

    public void setGenerId(int generId) {
        this.generId = generId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materialId != null ? materialId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialDesc)) {
            return false;
        }
        MaterialDesc other = (MaterialDesc) object;
        if ((this.materialId == null && other.materialId != null) || (this.materialId != null && !this.materialId.equals(other.materialId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MaterialDesc[ materialId=" + materialId + " ]";
    }
    
}
