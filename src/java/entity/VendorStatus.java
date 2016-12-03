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
@Table(name = "vendor_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VendorStatus.findAll", query = "SELECT v FROM VendorStatus v"),
    @NamedQuery(name = "VendorStatus.findByVendorStatusId", query = "SELECT v FROM VendorStatus v WHERE v.vendorStatusId = :vendorStatusId"),
    @NamedQuery(name = "VendorStatus.findByVendorStatusDesc", query = "SELECT v FROM VendorStatus v WHERE v.vendorStatusDesc = :vendorStatusDesc")})
public class VendorStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vendor_status_id")
    private Integer vendorStatusId;
    @Basic(optional = false)
    @Column(name = "vendor_status_desc")
    private String vendorStatusDesc;

    public VendorStatus() {
    }

    public VendorStatus(Integer vendorStatusId) {
        this.vendorStatusId = vendorStatusId;
    }

    public VendorStatus(Integer vendorStatusId, String vendorStatusDesc) {
        this.vendorStatusId = vendorStatusId;
        this.vendorStatusDesc = vendorStatusDesc;
    }

    public Integer getVendorStatusId() {
        return vendorStatusId;
    }

    public void setVendorStatusId(Integer vendorStatusId) {
        this.vendorStatusId = vendorStatusId;
    }

    public String getVendorStatusDesc() {
        return vendorStatusDesc;
    }

    public void setVendorStatusDesc(String vendorStatusDesc) {
        this.vendorStatusDesc = vendorStatusDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendorStatusId != null ? vendorStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VendorStatus)) {
            return false;
        }
        VendorStatus other = (VendorStatus) object;
        if ((this.vendorStatusId == null && other.vendorStatusId != null) || (this.vendorStatusId != null && !this.vendorStatusId.equals(other.vendorStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VendorStatus[ vendorStatusId=" + vendorStatusId + " ]";
    }
    
}
