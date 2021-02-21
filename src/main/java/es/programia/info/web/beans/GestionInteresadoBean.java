
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

    //private Collection<Interesado> coleccionInteresados;
    private Interesado interesado = new Interesado();
    private boolean editable=false;
    //private String emailABuscar;
    private boolean visible= false;
    
    @EJB private InteresadosServiceLocal interesadoService;
    
    
    public GestionInteresadoBean() {
        System.out.println(".... instanciando GestionBuscarInteresadoBean");
    }
    
    @PostConstruct
    public void inicializar(){
        
//        this.coleccionInteresados = interesadoService.buscarInteresadoPorCriterio();
    }

    /*
    public Collection<Interesado> getColeccionInteresados() {
        return coleccionInteresados;
    }
*/
    
    

    public Interesado buscar(){
        
        try {           
            interesado = interesadoService.buscarInteresadoPorCriterio(interesado.getNombre(), interesado.getApellidos(), interesado.getEmpresa());
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("usuario encontrado"));  
            return null;
        } catch (GestionSolicitudesException ex) {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("No se pudo modificar. " + ex.getMessage()));        
        }catch(Exception e){
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Error no controlado. " + e.getMessage())); 
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    public String modificarInteresado(){
        System.out.println(" ha modificar " + this.interesado.getNombre());
        
        try {           
            this.interesadoService.modificarInteresado(interesado);
            this.inicializar();
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("usuario encontrado"));  
            return null;
        } catch (GestionSolicitudesException ex) {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("No se pudo modificar. " + ex.getMessage()));        
        }catch(Exception e){
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Error no controlado. " + e.getMessage())); 
            e.printStackTrace();
        }
        return null;
    }
    
     public void mostarInteresado(int i){
        try {
//            this.interesadoEncontrado = interesadoService.getInteresado;
//            
            this.interesado.setNombre("....Ha cambiado");
            this.interesadoService.modificarInteresado(interesado);
        } catch (GestionSolicitudesException ex) {
            Logger.getLogger(GestionInteresadoBean.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (GestionSolicitudesException ex) {
//           Logger.getLogger(GestionInteresadoBean.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public void grabar(Interesado interesado) {
//        try {
//            this.interesadoService.grabar(idInteresadoAGrabar);
//             this.coleccionInteresados =   interesadoService.getAllInteresado();
//        } catch (GestionSolicitudesException ex) {            
//            FacesContext fc = FacesContext.getCurrentInstance();
//            fc.addMessage(null, new FacesMessage("No se pudo grabar. " + ex.getMessage())); 
//         }
//            return null;
    }
    
    public String  modoNuevo(){
        visible=true;
        return null;
        
    }
     
    /*
      public void editar(Interesado interesado) {
      
    }
      
       public void alta(Interesado interesado) {
       
    }
    
     public void visible(Interesado interesado) {
       
    }
*/

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
     
     
     
}
