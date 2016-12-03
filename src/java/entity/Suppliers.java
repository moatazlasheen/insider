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
@Table(name = "suppliers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suppliers.findAll", query = "SELECT s FROM Suppliers s"),
    @NamedQuery(name = "Suppliers.findBySuppliersId", query = "SELECT s FROM Suppliers s WHERE s.suppliersId = :suppliersId"),
    @NamedQuery(name = "Suppliers.findBySupplierName", query = "SELECT s FROM Suppliers s WHERE s.supplierName = :supplierName"),
    @NamedQuery(name = "Suppliers.findByCompanyName", query = "SELECT s FROM Suppliers s WHERE s.companyName = :companyName"),
    @NamedQuery(name = "Suppliers.findByVendorCode", query = "SELECT s FROM Suppliers s WHERE s.vendorCode = :vendorCode"),
    @NamedQuery(name = "Suppliers.findByVendorRepresentId", query = "SELECT s FROM Suppliers s WHERE s.vendorRepresentId = :vendorRepresentId"),
    @NamedQuery(name = "Suppliers.findByPhone", query = "SELECT s FROM Suppliers s WHERE s.phone = :phone"),
    @NamedQuery(name = "Suppliers.findByCell", query = "SELECT s FROM Suppliers s WHERE s.cell = :cell"),
    @NamedQuery(name = "Suppliers.findByFax", query = "SELECT s FROM Suppliers s WHERE s.fax = :fax"),
    @NamedQuery(name = "Suppliers.findByEmail", query = "SELECT s FROM Suppliers s WHERE s.email = :email"),
    @NamedQuery(name = "Suppliers.findByLocationId", query = "SELECT s FROM Suppliers s WHERE s.locationId = :locationId"),
    @NamedQuery(name = "Suppliers.findByVendorTypeId", query = "SELECT s FROM Suppliers s WHERE s.vendorTypeId = :vendorTypeId"),
    @NamedQuery(name = "Suppliers.findByRank", query = "SELECT s FROM Suppliers s WHERE s.rank = :rank"),
    @NamedQuery(name = "Suppliers.findByStatusId", query = "SELECT s FROM Suppliers s WHERE s.statusId = :statusId")})
public class Suppliers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "suppliers_id")
    private Integer suppliersId;
    @Basic(optional = false)
    @Column(name = "supplier_name")
    private String supplierName;
    @Basic(optional = false)
    @Column(name = "company_name")
    private String companyName;
    @Basic(optional = false)
    @Column(name = "vendor_code")
    private String vendorCode;
    @Basic(optional = false)
    @Column(name = "vendor_represent_id")
    private int vendorRepresentId;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "cell")
    private String cell;
    @Basic(optional = false)
    @Column(name = "fax")
    private String fax;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "location_id")
    private String locationId;
    @Basic(optional = false)
    @Column(name = "vendor_type_id")
    private int vendorTypeId;
    @Basic(optional = false)
    @Column(name = "rank")
    private String rank;
    @Basic(optional = false)
    @Column(name = "status_id")
    private int statusId;

    public Suppliers() {
    }

    public Suppliers(Integer suppliersId) {
        this.suppliersId = suppliersId;
    }

    public Suppliers(Integer suppliersId, String supplierName, String companyName, String vendorCode, int vendorRepresentId, String phone, String cell, String fax, String email, String locationId, int vendorTypeId, String rank, int statusId) {
        this.suppliersId = suppliersId;
        this.supplierName = supplierName;
        this.companyName = companyName;
        this.vendorCode = vendorCode;
        this.vendorRepresentId = vendorRepresentId;
        this.phone = phone;
        this.cell = cell;
        this.fax = fax;
        this.email = email;
        this.locationId = locationId;
        this.vendorTypeId = vendorTypeId;
        this.rank = rank;
        this.statusId = statusId;
    }

    public Integer getSuppliersId() {
        return suppliersId;
    }

    public void setSuppliersId(Integer suppliersId) {
        this.suppliersId = suppliersId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public int getVendorRepresentId() {
        return vendorRepresentId;
    }

    public void setVendorRepresentId(int vendorRepresentId) {
        this.vendorRepresentId = vendorRepresentId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public int getVendorTypeId() {
        return vendorTypeId;
    }

    public void setVendorTypeId(int vendorTypeId) {
        this.vendorTypeId = vendorTypeId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (suppliersId != null ? suppliersId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suppliers)) {
            return false;
        }
        Suppliers other = (Suppliers) object;
        if ((this.suppliersId == null && other.suppliersId != null) || (this.suppliersId != null && !this.suppliersId.equals(other.suppliersId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Suppliers[ suppliersId=" + suppliersId + " ]";
    }
    
}
