
package es.programia.info.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "SOLICITUDES_INFO")
@NamedQueries({
    @NamedQuery(name = "SolicitudInfo.findAll", query = "SELECT s FROM SolicitudInfo s"),
    @NamedQuery(name = "SolicitudInfo.findByIdSolicitud", query = "SELECT s FROM SolicitudInfo s WHERE s.idSolicitud = :idSolicitud"),
    @NamedQuery(name = "SolicitudInfo.findByFechaSolicitud", query = "SELECT s FROM SolicitudInfo s WHERE s.fechaSolicitud = :fechaSolicitud"),
    @NamedQuery(name = "SolicitudInfo.findByActivo", query = "SELECT s FROM SolicitudInfo s WHERE s.activo = :activo"),
    @NamedQuery(name = "SolicitudInfo.findByVersion", query = "SELECT s FROM SolicitudInfo s WHERE s.version = :version")})
public class SolicitudInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SOLICITUD")
    private Long idSolicitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_SOLICITUD")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVO")
    private int activo;
    @Column(name = "VERSION")
    private Integer version;
    @JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @JoinColumn(name = "ID_INTERESADO", referencedColumnName = "ID_INTERESADO")
    @ManyToOne(optional = false)
    private Interesado interesado;

    public SolicitudInfo() {
    }

    public SolicitudInfo(Long idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public SolicitudInfo(Long idSolicitud, Date fechaSolicitud, int activo) {
        this.idSolicitud = idSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.activo = activo;
    }

    public Long getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Long idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Interesado getIdInteresado() {
        return interesado;
    }

    public void setIdInteresado(Interesado idInteresado) {
        this.interesado = idInteresado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitud != null ? idSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudInfo)) {
            return false;
        }
        SolicitudInfo other = (SolicitudInfo) object;
        if ((this.idSolicitud == null && other.idSolicitud != null) || (this.idSolicitud != null && !this.idSolicitud.equals(other.idSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.programia.info.entidades.SolicitudInfo[ idSolicitud=" + idSolicitud + " ]";
    }
    
}
