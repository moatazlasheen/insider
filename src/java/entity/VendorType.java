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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author elsaidel
 */
@Entity
@Table(name = "vendor_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VendorType.findAll", query = "SELECT v FROM VendorType v"),
    @NamedQuery(name = "VendorType.findByVendorTypeId", query = "SELECT v FROM VendorType v WHERE v.vendorTypeId = :vendorTypeId"),
    @NamedQuery(name = "VendorType.findByVendorTypeDesc", query = "SELECT v FROM VendorType v WHERE v.vendorTypeDesc = :vendorTypeDesc")})
public class VendorType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vendor_type_id")
    private Integer vendorTypeId;
    @Basic(optional = false)
    @Column(name = "vendor_type_desc")
    private String vendorTypeDesc;

    public VendorType() {
    }

    public VendorType(Integer vendorTypeId) {
        this.vendorTypeId = vendorTypeId;
    }

    public VendorType(Integer vendorTypeId, String vendorTypeDesc) {
        this.vendorTypeId = vendorTypeId;
        this.vendorTypeDesc = vendorTypeDesc;
    }

    public Integer getVendorTypeId() {
        return vendorTypeId;
    }

    public void setVendorTypeId(Integer vendorTypeId) {
        this.vendorTypeId = vendorTypeId;
    }

    public String getVendorTypeDesc() {
        return vendorTypeDesc;
    }

    public void setVendorTypeDesc(String vendorTypeDesc) {
        this.vendorTypeDesc = vendorTypeDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendorTypeId != null ? vendorTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VendorType)) {
            return false;
        }
        VendorType other = (VendorType) object;
        if ((this.vendorTypeId == null && other.vendorTypeId != null) || (this.vendorTypeId != null && !this.vendorTypeId.equals(other.vendorTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VendorType[ vendorTypeId=" + vendorTypeId + " ]";
    }
    
}
