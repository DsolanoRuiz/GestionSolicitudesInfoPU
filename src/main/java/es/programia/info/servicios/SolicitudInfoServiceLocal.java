
package es.programia.info.servicios;

import es.programia.info.entidades.SolicitudInfo;
import java.util.Collection;
import java.util.Date;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;


@TransactionManagement(TransactionManagementType.CONTAINER)
public interface SolicitudInfoServiceLocal {
  
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Collection<SolicitudInfo> getColeccionSolicitudInfo(Long idSolicitud, Date fechaSolicitud, int activo);
    
}
