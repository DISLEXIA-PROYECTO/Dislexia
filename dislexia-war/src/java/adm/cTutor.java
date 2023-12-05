/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package adm;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
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
    
    public void validaC(FacesContext context, UIComponent toValidate, Object value){
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String correo = (String)value; 
        Pattern patron = Pattern.compile(regex);
        Matcher matcher = patron.matcher(correo);
        FacesMessage mensaje;
        
        if(correo.length() == 0){
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Correo no insertado","");
            context.addMessage(toValidate.getClientId(context), mensaje);
            ((UIInput)toValidate).setValid(false);
            return;
        }
        
        if(!matcher.find()){
           mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Correo invalido","El correo ingresado no está definido correctamente");
           context.addMessage(toValidate.getClientId(context),mensaje);
           ((UIInput)toValidate).setValid(false);
           return;
        }
    }
        
       public void validarG(FacesContext context, UIComponent toValidate, Object value) {
       String dato = (String)value;
       String regex = "^[a-zA-Z]+$";
       Pattern patron = Pattern.compile(regex);
       Matcher matcher = patron.matcher(dato);
       
       FacesMessage mensaje;
      
       if(!matcher.find()){
           mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Algunos campos contienen números", "El campo solo requiere de texto sin números o caracteres especiales");
           context.addMessage(toValidate.getClientId(context), mensaje);
           ((UIInput)toValidate).setValid(false);
           return;
       }
    }
    
    
    
}
