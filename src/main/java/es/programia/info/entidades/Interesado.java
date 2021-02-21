
package es.programia.info.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "INTERESADOS")
@NamedQueries({
    @NamedQuery(name = "Interesado.findAll", query = "SELECT i FROM Interesado i"),
    @NamedQuery(name = "Interesado.findByIdInteresado", query = "SELECT i FROM Interesado i WHERE i.idInteresado = :idInteresado"),
    @NamedQuery(name = "Interesado.findByNombre", query = "SELECT i FROM Interesado i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Interesado.findByApellidos", query = "SELECT i FROM Interesado i WHERE i.apellidos = :apellidos"),
    @NamedQuery(name = "Interesado.findByEmpresa", query = "SELECT i FROM Interesado i WHERE i.empresa = :empresa"),
    @NamedQuery(name = "Interesado.findByEMail", query = "SELECT i FROM Interesado i WHERE i.eMail = :eMail"),
    @NamedQuery(name = "Interesado.findByMovil", query = "SELECT i FROM Interesado i WHERE i.movil = :movil"),
    @NamedQuery(name = "Interesado.findByTelefono", query = "SELECT i FROM Interesado i WHERE i.telefono = :telefono"),
    @NamedQuery(name = "Interesado.findByProvincia", query = "SELECT i FROM Interesado i WHERE i.provincia = :provincia"),
    @NamedQuery(name = "Interesado.findByFechaAlta", query = "SELECT i FROM Interesado i WHERE i.fechaAlta = :fechaAlta"),
    @NamedQuery(name = "Interesado.findByEnviarNotificaciones", query = "SELECT i FROM Interesado i WHERE i.enviarNotificaciones = :enviarNotificaciones"),
    @NamedQuery(name = "Interesado.findByNombreApellidoEmpresa", 
                        query = "SELECT i FROM Interesado i WHERE i.nombre like :nombre AND "
                                + " i.apellidos like :apellidos AND "
                                + " i.empresa like :empresa "),
    @NamedQuery(name = "Interesado.findByVersion", query = "SELECT i FROM Interesado i WHERE i.version = :version")})
public class Interesado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_INTERESADO")
    private Long idInteresado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 75)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Size(max = 75)
    @Column(name = "EMPRESA")
    private String empresa;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "E_MAIL")
    private String eMail;
    @Size(max = 9)
    @Column(name = "MOVIL")
    private String movil;
    //@Size(max = 9)
    @Column(name = "TELEFONO")
    private String telefono;
    //@Size(max = 60)
    @Column(name = "PROVINCIA")
    private String provincia;
    @Column(name = "FECHA_ALTA")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENVIAR_NOTIFICACIONES")
    private short enviarNotificaciones;
    @Column(name = "VERSION")
    private Integer version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "interesado", fetch = FetchType.EAGER)
    private Collection<SolicitudInfo> solicitudInfoCollection;

    public Interesado() {
    }

    public Interesado(Long idInteresado) {
        this.idInteresado = idInteresado;
    }

    public Interesado(Long idInteresado, String nombre, short enviarNotificaciones) {
        this.idInteresado = idInteresado;
        this.nombre = nombre;
        this.enviarNotificaciones = enviarNotificaciones;
    }

    public Long getIdInteresado() {
        return idInteresado;
    }

    public void setIdInteresado(Long idInteresado) {
        this.idInteresado = idInteresado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public short getEnviarNotificaciones() {
        return enviarNotificaciones;
    }

    public void setEnviarNotificaciones(short enviarNotificaciones) {
        this.enviarNotificaciones = enviarNotificaciones;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Collection<SolicitudInfo> getSolicitudInfoCollection() {
        return solicitudInfoCollection;
    }

    public void setSolicitudInfoCollection(Collection<SolicitudInfo> solicitudInfoCollection) {
        this.solicitudInfoCollection = solicitudInfoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInteresado != null ? idInteresado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interesado)) {
            return false;
        }
        Interesado other = (Interesado) object;
        if ((this.idInteresado == null && other.idInteresado != null) || (this.idInteresado != null && !this.idInteresado.equals(other.idInteresado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.programia.info.entidades.Interesado[ idInteresado=" + idInteresado + " ]";
    }
    
}
