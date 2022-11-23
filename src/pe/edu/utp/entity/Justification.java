/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author zhaulvaldera
 */
@Entity
@Table(name = "justifications")
@NamedQueries({
    @NamedQuery(name = "Justification.findAll", query = "SELECT j FROM Justification j"),
    @NamedQuery(name = "Justification.findById", query = "SELECT j FROM Justification j WHERE j.id = :id"),
    @NamedQuery(name = "Justification.findByDate", query = "SELECT j FROM Justification j WHERE j.date = :date"),
    @NamedQuery(name = "Justification.findByFile", query = "SELECT j FROM Justification j WHERE j.file = :file"),
    @NamedQuery(name = "Justification.findByReason", query = "SELECT j FROM Justification j WHERE j.reason = :reason")})
public class Justification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "file")
    private String file;
    @Column(name = "reason")
    private String reason;
    @Lob
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "idShedule", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Schedule idShedule;

    public Justification() {
    }

    public Justification(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Schedule getIdShedule() {
        return idShedule;
    }

    public void setIdShedule(Schedule idShedule) {
        this.idShedule = idShedule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Justification)) {
            return false;
        }
        Justification other = (Justification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.utp.entity.Justification[ id=" + id + " ]";
    }
    
}
