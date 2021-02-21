package es.programia.info.servicios;

import es.programia.info.entidades.Interesado;
import es.programia.info.excepciones.GestionSolicitudesException;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.OptimisticLockException;
import javax.persistence.Query;

@Stateless
public class InteresadosService implements InteresadosServiceLocal {

    @PersistenceContext
    private EntityManager em;
    private Collection<Interesado> coleccionInteresados;
     
    @Override
    public Interesado buscarInteresadoPorCriterio(String nombre, String apellido, String empresa) throws GestionSolicitudesException {
        Query query = em.createNamedQuery("Interesado.findByNombreApellidoEmpresa");
        if (nombre == null) {
            nombre = "%";
        }

        if (apellido == null) {
            apellido = "%";
        }

        if (empresa == null) {
            empresa = "%";
        }

        query.setParameter("nombre", nombre);
        query.setParameter("apellido", apellido);
        query.setParameter("empresa", empresa);

        query.setMaxResults(1);

        List<Interesado> interesados = query.getResultList();
        if (interesados == null || interesados.size() == 0) {
            throw new GestionSolicitudesException("info_busqueda_no_resultados");
        }

        return interesados.get(0);
    }

    @Override
    public void crearNuevoInteresado(Interesado interesado) throws GestionSolicitudesException {
        em.persist(interesado);
    }

    @Override
    public void modificarInteresado(Interesado interesado) throws GestionSolicitudesException {
  try {
        Interesado i = em.find(Interesado.class, interesado.getIdInteresado());
        if (i == null) {
               throw new GestionSolicitudesException("error_uptdate_no_found");
        }
        em.merge(interesado);
    }catch(OptimisticLockException ole) {
      
            throw new GestionSolicitudesException("La persona interesada actual ya " +
                    "ha sido modificada por otra persona. Por favor, vuelve a recuperarlo.");
    }
        
    }
    /*
     public void grabar(Interesado interesado) {
       em.persist(interesado);
    }
     
      public void editar(Interesado interesado) {
       em.persist(interesado);
    }
      
       public void alta(Interesado interesado) {
       em.persist(interesado);
    }
*/
}