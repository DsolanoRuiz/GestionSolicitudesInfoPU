
package es.programia.info.servicios;

import es.programia.info.entidades.SolicitudInfo;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class SolicitudInfoService implements SolicitudInfoServiceLocal {

    @PersistenceContext(unitName = "GestionSolicitudesInfoPU")
    private EntityManager em;

    public Collection<SolicitudInfo> getColeccionSolicitudInfo (Long idSolicitud, Date fechaSolicitud, int activo) {
        Query query = em.createNamedQuery("SolicitudInfo.findByActivoAndIdSolicitud");
        query.setParameter("activo", activo);
        query.setParameter("idSolicitud", idSolicitud);
        return query.getResultList();
    }

//    @Override
//    public void alta(Solicitud solicitud) {
//       em.persist(solicitud);
//    }
}
