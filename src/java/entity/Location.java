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
@Table(name = "location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findByLocationId", query = "SELECT l FROM Location l WHERE l.locationId = :locationId"),
    @NamedQuery(name = "Location.findByLocation", query = "SELECT l FROM Location l WHERE l.location = :location"),
    @NamedQuery(name = "Location.findByCity", query = "SELECT l FROM Location l WHERE l.city = :city"),
    @NamedQuery(name = "Location.findByGoven", query = "SELECT l FROM Location l WHERE l.goven = :goven")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "location_id")
    private Integer locationId;
    @Basic(optional = false)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @Column(name = "goven")
    private String goven;

    public Location() {
    }

    public Location(Integer locationId) {
        this.locationId = locationId;
    }

    public Location(Integer locationId, String location, String city, String goven) {
        this.locationId = locationId;
        this.location = location;
        this.city = city;
        this.goven = goven;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGoven() {
        return goven;
    }

    public void setGoven(String goven) {
        this.goven = goven;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationId != null ? locationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.locationId == null && other.locationId != null) || (this.locationId != null && !this.locationId.equals(other.locationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Location[ locationId=" + locationId + " ]";
    }
    
}
