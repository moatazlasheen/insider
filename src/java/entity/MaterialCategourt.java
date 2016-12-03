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
 * @author mrnull <ahmadmoawad3@gmail.com>
 */
@Entity
@Table(name = "material_categourt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialCategourt.findAll", query = "SELECT m FROM MaterialCategourt m")
    , @NamedQuery(name = "MaterialCategourt.findByMaterailCategouryId", query = "SELECT m FROM MaterialCategourt m WHERE m.materailCategouryId = :materailCategouryId")
    , @NamedQuery(name = "MaterialCategourt.findByMaterialCategouryDesc", query = "SELECT m FROM MaterialCategourt m WHERE m.materialCategouryDesc = :materialCategouryDesc")})
public class MaterialCategourt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "materail_categoury_id")
    private Integer materailCategouryId;
    @Column(name = "material_Categoury_Desc")
    private String materialCategouryDesc;

    public MaterialCategourt() {
    }

    public MaterialCategourt(Integer materailCategouryId) {
        this.materailCategouryId = materailCategouryId;
    }

    public Integer getMaterailCategouryId() {
        return materailCategouryId;
    }

    public void setMaterailCategouryId(Integer materailCategouryId) {
        this.materailCategouryId = materailCategouryId;
    }

    public String getMaterialCategouryDesc() {
        return materialCategouryDesc;
    }

    public void setMaterialCategouryDesc(String materialCategouryDesc) {
        this.materialCategouryDesc = materialCategouryDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materailCategouryId != null ? materailCategouryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialCategourt)) {
            return false;
        }
        MaterialCategourt other = (MaterialCategourt) object;
        if ((this.materailCategouryId == null && other.materailCategouryId != null) || (this.materailCategouryId != null && !this.materailCategouryId.equals(other.materailCategouryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MaterialCategourt[ materailCategouryId=" + materailCategouryId + " ]";
    }

}
