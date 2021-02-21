
package es.programia.info.excepciones;

import java.io.Serializable;
import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class GestionSolicitudesException extends Exception implements Serializable {

    private String[] params;  
    
    public GestionSolicitudesException(String message, String... params) {
        super(message);
        if(params !=null){
            this.params= this.params;
        } 
    }
    
      public GestionSolicitudesException(String message, Throwable cause) {
        super(message, cause);
      }

    public String[] getParams() {
        return params;
    }
      
     
}
