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
@Table(name = "vendor_represent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VendorRepresent.findAll", query = "SELECT v FROM VendorRepresent v"),
    @NamedQuery(name = "VendorRepresent.findByVendorRepresentId", query = "SELECT v FROM VendorRepresent v WHERE v.vendorRepresentId = :vendorRepresentId"),
    @NamedQuery(name = "VendorRepresent.findByVendorName", query = "SELECT v FROM VendorRepresent v WHERE v.vendorName = :vendorName"),
    @NamedQuery(name = "VendorRepresent.findByVendorTitle", query = "SELECT v FROM VendorRepresent v WHERE v.vendorTitle = :vendorTitle"),
    @NamedQuery(name = "VendorRepresent.findByVendorStatus", query = "SELECT v FROM VendorRepresent v WHERE v.vendorStatus = :vendorStatus"),
    @NamedQuery(name = "VendorRepresent.findByVendorPhone", query = "SELECT v FROM VendorRepresent v WHERE v.vendorPhone = :vendorPhone"),
    @NamedQuery(name = "VendorRepresent.findByVendorCell", query = "SELECT v FROM VendorRepresent v WHERE v.vendorCell = :vendorCell"),
    @NamedQuery(name = "VendorRepresent.findByVendorExt", query = "SELECT v FROM VendorRepresent v WHERE v.vendorExt = :vendorExt"),
    @NamedQuery(name = "VendorRepresent.findByVendorEmail", query = "SELECT v FROM VendorRepresent v WHERE v.vendorEmail = :vendorEmail"),
    @NamedQuery(name = "VendorRepresent.findByLocaionId", query = "SELECT v FROM VendorRepresent v WHERE v.locaionId = :locaionId")})
public class VendorRepresent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vendor_represent_id")
    private Integer vendorRepresentId;
    @Basic(optional = false)
    @Column(name = "vendor_name")
    private String vendorName;
    @Basic(optional = false)
    @Column(name = "vendor_title")
    private String vendorTitle;
    @Basic(optional = false)
    @Column(name = "vendor_status")
    private String vendorStatus;
    @Basic(optional = false)
    @Column(name = "vendor_phone")
    private String vendorPhone;
    @Basic(optional = false)
    @Column(name = "vendor_cell")
    private String vendorCell;
    @Basic(optional = false)
    @Column(name = "vendor_ext")
    private String vendorExt;
    @Basic(optional = false)
    @Column(name = "vendor_email")
    private String vendorEmail;
    @Basic(optional = false)
    @Column(name = "locaion_id")
    private int locaionId;

    public VendorRepresent() {
    }

    public VendorRepresent(Integer vendorRepresentId) {
        this.vendorRepresentId = vendorRepresentId;
    }

    public VendorRepresent(Integer vendorRepresentId, String vendorName, String vendorTitle, String vendorStatus, String vendorPhone, String vendorCell, String vendorExt, String vendorEmail, int locaionId) {
        this.vendorRepresentId = vendorRepresentId;
        this.vendorName = vendorName;
        this.vendorTitle = vendorTitle;
        this.vendorStatus = vendorStatus;
        this.vendorPhone = vendorPhone;
        this.vendorCell = vendorCell;
        this.vendorExt = vendorExt;
        this.vendorEmail = vendorEmail;
        this.locaionId = locaionId;
    }

    public Integer getVendorRepresentId() {
        return vendorRepresentId;
    }

    public void setVendorRepresentId(Integer vendorRepresentId) {
        this.vendorRepresentId = vendorRepresentId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorTitle() {
        return vendorTitle;
    }

    public void setVendorTitle(String vendorTitle) {
        this.vendorTitle = vendorTitle;
    }

    public String getVendorStatus() {
        return vendorStatus;
    }

    public void setVendorStatus(String vendorStatus) {
        this.vendorStatus = vendorStatus;
    }

    public String getVendorPhone() {
        return vendorPhone;
    }

    public void setVendorPhone(String vendorPhone) {
        this.vendorPhone = vendorPhone;
    }

    public String getVendorCell() {
        return vendorCell;
    }

    public void setVendorCell(String vendorCell) {
        this.vendorCell = vendorCell;
    }

    public String getVendorExt() {
        return vendorExt;
    }

    public void setVendorExt(String vendorExt) {
        this.vendorExt = vendorExt;
    }

    public String getVendorEmail() {
        return vendorEmail;
    }

    public void setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
    }

    public int getLocaionId() {
        return locaionId;
    }

    public void setLocaionId(int locaionId) {
        this.locaionId = locaionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendorRepresentId != null ? vendorRepresentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VendorRepresent)) {
            return false;
        }
        VendorRepresent other = (VendorRepresent) object;
        if ((this.vendorRepresentId == null && other.vendorRepresentId != null) || (this.vendorRepresentId != null && !this.vendorRepresentId.equals(other.vendorRepresentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VendorRepresent[ vendorRepresentId=" + vendorRepresentId + " ]";
    }
    
}
