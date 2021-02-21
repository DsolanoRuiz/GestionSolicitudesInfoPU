
package es.programia.info.web.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;


@Named(value = "idioma")
@SessionScoped
public class IdiomaBean implements Serializable {

    private String idioma = "es";

    public String getIdioma() {
        return idioma;
    }
  
    public IdiomaBean() {
        
    }
    
    //Acción
    public String cambiarIdioma(String nuevo){
        this.idioma= nuevo;
        return null;
    }
    
}
