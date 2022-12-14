
package pe.edu.utp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author zhaulvaldera
 */
@Entity
@Table(name = "employees")
@NamedQueries({
    @NamedQuery(name = "Employe.findAll", query = "SELECT e FROM Employe e"),
    @NamedQuery(name = "Employe.findById", query = "SELECT e FROM Employe e WHERE e.id = :id"),
    @NamedQuery(name = "Employe.findByUserAndPassword", query = "SELECT e FROM Employe e WHERE e.user = :user and e.password = :password and e.flagAccess = '1'"),
    @NamedQuery(name = "Employe.findByNames", query = "SELECT e FROM Employe e WHERE e.names = :names"),
    @NamedQuery(name = "Employe.findByLastNames", query = "SELECT e FROM Employe e WHERE e.lastNames = :lastNames"),
    @NamedQuery(name = "Employe.findByTypeDocument", query = "SELECT e FROM Employe e WHERE e.typeDocument = :typeDocument"),
    @NamedQuery(name = "Employe.findByNumberDocument", query = "SELECT e FROM Employe e WHERE e.numberDocument = :numberDocument"),
    @NamedQuery(name = "Employe.findByStatus", query = "SELECT e FROM Employe e WHERE e.status = :status"),
    @NamedQuery(name = "Employe.findByEmail", query = "SELECT e FROM Employe e WHERE e.email = :email"),
    @NamedQuery(name = "Employe.findBySex", query = "SELECT e FROM Employe e WHERE e.sex = :sex"),
    @NamedQuery(name = "Employe.findByAddress", query = "SELECT e FROM Employe e WHERE e.address = :address"),
    @NamedQuery(name = "Employe.findByDateBirth", query = "SELECT e FROM Employe e WHERE e.dateBirth = :dateBirth"),
    @NamedQuery(name = "Employe.findByPhone", query = "SELECT e FROM Employe e WHERE e.phone = :phone"),
    @NamedQuery(name = "Employe.findByDateStart", query = "SELECT e FROM Employe e WHERE e.dateStart = :dateStart"),
    @NamedQuery(name = "Employe.findByPassword", query = "SELECT e FROM Employe e WHERE e.password = :password"),
    @NamedQuery(name = "Employe.findByFlagAccess", query = "SELECT e FROM Employe e WHERE e.flagAccess = :flagAccess"),
    @NamedQuery(name = "Employe.findByCodeEmployee", query = "SELECT e FROM Employe e WHERE e.codeEmployee = :codeEmployee"),
    @NamedQuery(name = "Employe.findByUser", query = "SELECT e FROM Employe e WHERE e.user = :user")})
public class Employe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "names")
    private String names;
    @Basic(optional = false)
    @Column(name = "lastNames")
    private String lastNames;
    @Basic(optional = false)
    @Column(name = "typeDocument")
    private String typeDocument;
    @Basic(optional = false)
    @Column(name = "numberDocument")
    private String numberDocument;
    @Basic(optional = false)
    @Column(name = "status")
    private Character status;
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "sex")
    private Character sex;
    @Column(name = "address")
    private String address;
    @Column(name = "dateBirth")
    @Temporal(TemporalType.DATE)
    private Date dateBirth;
    @Column(name = "phone")
    private String phone;
    @Column(name = "dateStart")
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    @Column(name = "password")
    private String password;
    @Column(name = "flagAccess")
    private Character flagAccess;
    @Basic(optional = false)
    @Column(name = "codeEmployee")
    private String codeEmployee;
    @Column(name = "user")
    private String user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmploye")
    private List<Schedule> scheduleList;
    @JoinColumn(name = "idCargo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CargoPersonal idCargo;
    @JoinColumn(name = "idRol", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Rol idRol;

    public Employe() {
    }

    public Employe(Integer id) {
        this.id = id;
    }

    public Employe(Integer id, String names, String lastNames, String typeDocument, String numberDocument, Character status, Character sex, String codeEmployee) {
        this.id = id;
        this.names = names;
        this.lastNames = lastNames;
        this.typeDocument = typeDocument;
        this.numberDocument = numberDocument;
        this.status = status;
        this.sex = sex;
        this.codeEmployee = codeEmployee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(String numberDocument) {
        this.numberDocument = numberDocument;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Character getFlagAccess() {
        return flagAccess;
    }

    public void setFlagAccess(Character flagAccess) {
        this.flagAccess = flagAccess;
    }

    public String getCodeEmployee() {
        return codeEmployee;
    }

    public void setCodeEmployee(String codeEmployee) {
        this.codeEmployee = codeEmployee;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public CargoPersonal getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(CargoPersonal idCargo) {
        this.idCargo = idCargo;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
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
        if (!(object instanceof Employe)) {
            return false;
        }
        Employe other = (Employe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.utp.entity.Employe[ id=" + id + " ]";
    }
    
}
