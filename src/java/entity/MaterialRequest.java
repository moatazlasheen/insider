/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author elsaidel
 */
@Entity
@Table(name = "MATERIAL_REQUEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialRequest.findAll", query = "SELECT m FROM MaterialRequest m"),
    @NamedQuery(name = "MaterialRequest.findByMrId", query = "SELECT m FROM MaterialRequest m WHERE m.mrId = :mrId"),
    @NamedQuery(name = "MaterialRequest.findByMrCode", query = "SELECT m FROM MaterialRequest m WHERE m.mrCode = :mrCode"),
    @NamedQuery(name = "MaterialRequest.findByMrDate", query = "SELECT m FROM MaterialRequest m WHERE m.mrDate = :mrDate"),
    @NamedQuery(name = "MaterialRequest.findByMaterialTypeId", query = "SELECT m FROM MaterialRequest m WHERE m.materialTypeId = :materialTypeId"),
    @NamedQuery(name = "MaterialRequest.findByProjectItemCode", query = "SELECT m FROM MaterialRequest m WHERE m.projectItemCode = :projectItemCode"),
    @NamedQuery(name = "MaterialRequest.findByItemDescId", query = "SELECT m FROM MaterialRequest m WHERE m.itemDescId = :itemDescId"),
    @NamedQuery(name = "MaterialRequest.findByMrQuantity", query = "SELECT m FROM MaterialRequest m WHERE m.mrQuantity = :mrQuantity"),
    @NamedQuery(name = "MaterialRequest.findByUnitId", query = "SELECT m FROM MaterialRequest m WHERE m.unitId = :unitId"),
    @NamedQuery(name = "MaterialRequest.findByRemark", query = "SELECT m FROM MaterialRequest m WHERE m.remark = :remark")})
public class MaterialRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mr_id")
    private Integer mrId;
    @Basic(optional = false)
    @Column(name = "mr_code")
    private String mrCode;
    @Basic(optional = false)
    @Column(name = "mr_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mrDate;
    @Column(name = "material_type_id")
    private Integer materialTypeId;
    @Basic(optional = false)
    @Column(name = "project_item_code")
    private String projectItemCode;
    @Basic(optional = false)
    @Column(name = "item_desc_id")
    private int itemDescId;
    @Basic(optional = false)
    @Column(name = "MR_QUANTITY")
    private int mrQuantity;
    @Basic(optional = false)
    @Column(name = "UNIT_ID")
    private int unitId;
    @Basic(optional = false)
    @Lob
    @Column(name = "ATTACH_FILE")
    private byte[] attachFile;
    @Lob
    @Column(name = "PIC")
    private byte[] pic;
    @Column(name = "REMARK")
    private String remark;

    public MaterialRequest() {
    }

    public MaterialRequest(Integer mrId) {
        this.mrId = mrId;
    }

    public MaterialRequest(Integer mrId, String mrCode, Date mrDate, String projectItemCode, int itemDescId, int mrQuantity, int unitId, byte[] attachFile) {
        this.mrId = mrId;
        this.mrCode = mrCode;
        this.mrDate = mrDate;
        this.projectItemCode = projectItemCode;
        this.itemDescId = itemDescId;
        this.mrQuantity = mrQuantity;
        this.unitId = unitId;
        this.attachFile = attachFile;
    }

    public Integer getMrId() {
        return mrId;
    }

    public void setMrId(Integer mrId) {
        this.mrId = mrId;
    }

    public String getMrCode() {
        return mrCode;
    }

    public void setMrCode(String mrCode) {
        this.mrCode = mrCode;
    }

    public Date getMrDate() {
        return mrDate;
    }

    public void setMrDate(Date mrDate) {
        this.mrDate = mrDate;
    }

    public Integer getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(Integer materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public String getProjectItemCode() {
        return projectItemCode;
    }

    public void setProjectItemCode(String projectItemCode) {
        this.projectItemCode = projectItemCode;
    }

    public int getItemDescId() {
        return itemDescId;
    }

    public void setItemDescId(int itemDescId) {
        this.itemDescId = itemDescId;
    }

    public int getMrQuantity() {
        return mrQuantity;
    }

    public void setMrQuantity(int mrQuantity) {
        this.mrQuantity = mrQuantity;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public byte[] getAttachFile() {
        return attachFile;
    }

    public void setAttachFile(byte[] attachFile) {
        this.attachFile = attachFile;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mrId != null ? mrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialRequest)) {
            return false;
        }
        MaterialRequest other = (MaterialRequest) object;
        if ((this.mrId == null && other.mrId != null) || (this.mrId != null && !this.mrId.equals(other.mrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MaterialRequest[ mrId=" + mrId + " ]";
    }
    
}
