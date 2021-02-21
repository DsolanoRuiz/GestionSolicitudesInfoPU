package es.programia.info.web.beans;

import es.programia.info.entidades.Interesado;
import es.programia.info.excepciones.GestionSolicitudesException;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import es.programia.info.servicios.InteresadosServiceLocal;

@Named(value = "gestion")
@SessionScoped
public class GestionInteresadoBean implements Serializable {

    private Collection<Interesado> coleccInteresados;
    private Interesado interesado = new Interesado();
    private boolean editable = false;
    private boolean visible = false;
    private boolean accionNuevo = false;
    private boolean accionModificar = false;
    @EJB
    private InteresadosServiceLocal interesadoService;
    //private Logger log;   // = Logger.getLogger("GestionInteresadoBean");

    public GestionInteresadoBean() {
        System.out.println(".... instanciando GestionBuscarInteresadoBean");
    }

    @PostConstruct
    public void inicializar() {
        this.coleccInteresados = interesadoService.getAllInteresados();
    }

    public Collection<Interesado> getColeccInteresados() {
        return coleccInteresados;
    }

    public Interesado getInteresado() {
        return interesado;
    }

    public void setInteresado(Interesado interesado) {
        this.interesado = interesado;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean Visible) {
        this.visible = Visible;
    }

    public boolean isAccionNuevo() {
        return accionNuevo;
    }

    public void setAccionNuevo(boolean accionNuevo) {
        this.accionNuevo = accionNuevo;
    }

    public boolean isAccionModificar() {
        return accionModificar;
    }

    public void setAccionModificar(boolean accionModificar) {
        this.accionModificar = accionModificar;
    }

    public InteresadosServiceLocal getInteresadoService() {
        return interesadoService;
    }

    public void setInteresadoService(InteresadosServiceLocal interesadoService) {
        this.interesadoService = interesadoService;
    }

    public String buscar() {
        try {
            this.interesado = interesadoService.buscarInteresadoPorCriterio(interesado.getNombre(), interesado.getApellidos(), interesado.getEmpresa());
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("usuario encontrado"));
            return null;
        } catch (GestionSolicitudesException ex) {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("No se pudo modificar. " + ex.getMessage()));
        } catch (Exception e) {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Error no controlado. " + e.getMessage()));
            e.printStackTrace();
        }
        return null;
    }

   
    public String grabar() {

        if (accionNuevo == true) {
            try {
                this.interesadoService.crearNuevoInteresado(interesado);
                this.inicializar();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Interesado  ha sido creado"));
            } catch (GestionSolicitudesException ex) {
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("El interesado no se ha sido creado"));
                return null;
            }

        } else if (accionModificar == true) {
            try {
                interesadoService.modificarInteresado(interesado);
            } catch (GestionSolicitudesException ex) {
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Interesado modificado. " + ex.getMessage()));
            } catch (Exception e) {
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Interesado no ha sido modificado. " + e.getMessage()));
                e.printStackTrace();
            }
        }
        return null;
    }

    public String modoNuevo() {
        visible = true;
        accionNuevo = true;
        editable = true;
        return null;

    }

     public String editar() {
        editable = true;
        accionNuevo = true;
        accionModificar = true;
       return null;

    }     
      public String modificar() {
        editable = true;
        accionModificar = true;
       return null;
       
    }
    
    public String cancelar() {
        return "solicitud_info1";
    }
}
