
package es.programia.info.servicios;

import es.programia.info.entidades.Interesado;
import es.programia.info.excepciones.GestionSolicitudesException;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;


@TransactionManagement(TransactionManagementType.CONTAINER)
public interface InteresadosServiceLocal {
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    Interesado buscarInteresadoPorCriterio(String nombre, String apellido, String Empresa) throws GestionSolicitudesException;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crearNuevoInteresado(Interesado interesado) throws GestionSolicitudesException;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void modificarInteresado (Interesado interesado) throws GestionSolicitudesException;
    
}
