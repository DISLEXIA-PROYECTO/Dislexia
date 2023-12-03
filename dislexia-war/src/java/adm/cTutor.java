/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package adm;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import log_neg.LnTutor;
import log_neg.LnUsuario;
import modelo.Tutor;
import modelo.Usuario;

/**
 *
 * @author ale_j
 */
@Named(value = "cTutor")
@SessionScoped
public class cTutor implements Serializable {

    @EJB
    private LnUsuario lnUsuario;

    @EJB
    private LnTutor lnTutor;

    private Tutor tutor; 
    
    
    public cTutor() {
        tutor = new Tutor();
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
    
    public void registrarTutor(){
        lnTutor.registrar(tutor);
    }  
    
    public void busquedaTutorado(String usuario){
        Usuario user =lnUsuario.existeUU(usuario);
        if(user != null){
            tutor.setIdtutorado(user);
        }
    }
     
    
    
}
