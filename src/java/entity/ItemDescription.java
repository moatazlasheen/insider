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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ramy
 */
@Entity
@Table(name = "item_description", catalog = "insider3_insider360", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"item_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemDescription.findAll", query = "SELECT i FROM ItemDescription i"),
    @NamedQuery(name = "ItemDescription.findByItemId", query = "SELECT i FROM ItemDescription i WHERE i.itemId = :itemId"),
    @NamedQuery(name = "ItemDescription.findByItemCode", query = "SELECT i FROM ItemDescription i WHERE i.itemCode = :itemCode"),
    @NamedQuery(name = "ItemDescription.findByItemDesc", query = "SELECT i FROM ItemDescription i WHERE i.itemDesc = :itemDesc"),
    @NamedQuery(name = "ItemDescription.findByItemTypeId", query = "SELECT i FROM ItemDescription i WHERE i.itemTypeId = :itemTypeId"),
    @NamedQuery(name = "ItemDescription.findByUnitId", query = "SELECT i FROM ItemDescription i WHERE i.unitId = :unitId"),
    @NamedQuery(name = "ItemDescription.findByUdf1", query = "SELECT i FROM ItemDescription i WHERE i.udf1 = :udf1"),
    @NamedQuery(name = "ItemDescription.findByUdf2", query = "SELECT i FROM ItemDescription i WHERE i.udf2 = :udf2"),
    @NamedQuery(name = "ItemDescription.findByUdf3", query = "SELECT i FROM ItemDescription i WHERE i.udf3 = :udf3"),
    @NamedQuery(name = "ItemDescription.findByUdf4", query = "SELECT i FROM ItemDescription i WHERE i.udf4 = :udf4"),
    @NamedQuery(name = "ItemDescription.findByUdf5", query = "SELECT i FROM ItemDescription i WHERE i.udf5 = :udf5"),
    @NamedQuery(name = "ItemDescription.findByGenerId", query = "SELECT i FROM ItemDescription i WHERE i.generId = :generId")})
public class ItemDescription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "item_id", nullable = false)
    private Integer itemId;
    @Basic(optional = false)
    @Column(name = "item_code", nullable = false)
    private int itemCode;
    @Column(name = "item_desc", length = 150)
    private String itemDesc;
    @Basic(optional = false)
    @Column(name = "item_type_id", nullable = false)
    private int itemTypeId;
    @Basic(optional = false)
    @Column(name = "unit_id", nullable = false)
    private int unitId;
    @Lob
    private byte[] upload;
    @Column(name = "udf_1", length = 50)
    private String udf1;
    @Column(name = "udf_2", length = 50)
    private String udf2;
    @Column(name = "udf_3", length = 50)
    private String udf3;
    @Column(name = "udf_4", length = 50)
    private String udf4;
    @Column(name = "udf_5", length = 50)
    private String udf5;
    @Basic(optional = false)
    @Column(name = "gener_id", nullable = false)
    private int generId;
    @Column(name = "upload_file_name")
    private String uploadFileName;

    public ItemDescription() {
    }

    public ItemDescription(Integer itemId) {
        this.itemId = itemId;
    }

    public ItemDescription(Integer itemId, int itemCode, int itemTypeId, int unitId, int generId, String uploadFileName) {
        this.itemId = itemId;
        this.itemCode = itemCode;
        this.itemTypeId = itemTypeId;
        this.unitId = unitId;
        this.generId = generId;
        this.uploadFileName = uploadFileName;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public int getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(int itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public byte[] getUpload() {
        return upload;
    }

    public void setUpload(byte[] upload) {
        this.upload = upload;
    }

    public String getUdf1() {
        return udf1;
    }

    public void setUdf1(String udf1) {
        this.udf1 = udf1;
    }

    public String getUdf2() {
        return udf2;
    }

    public void setUdf2(String udf2) {
        this.udf2 = udf2;
    }

    public String getUdf3() {
        return udf3;
    }

    public void setUdf3(String udf3) {
        this.udf3 = udf3;
    }

    public String getUdf4() {
        return udf4;
    }

    public void setUdf4(String udf4) {
        this.udf4 = udf4;
    }

    public String getUdf5() {
        return udf5;
    }

    public void setUdf5(String udf5) {
        this.udf5 = udf5;
    }

    public int getGenerId() {
        return generId;
    }

    public void setGenerId(int generId) {
        this.generId = generId;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemDescription)) {
            return false;
        }
        ItemDescription other = (ItemDescription) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ItemDescription[ itemId=" + itemId + " ]";
    }

}
