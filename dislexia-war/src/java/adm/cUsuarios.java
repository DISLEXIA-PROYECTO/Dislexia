/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package adm;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import log_neg.LnUsuario;
import modelo.Usuario;

/**
 *
 * @author ale_j
 */
@Named(value = "cUsuarios")
@SessionScoped
public class cUsuarios implements Serializable {

    @EJB
    private LnUsuario lnUsuario;

    private Usuario usuario;

    public cUsuarios() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String registrar() {
        lnUsuario.registrar(usuario);
        return "registroTutor";
    }

    public String log(FacesContext context, UIComponent toValidate, Object value) {
        String us = usuario.getUsuario();
        String pass = usuario.getContrasenia();
        if (lnUsuario.usuarioLog(us, pass) != null) {
            return "informacion";
        }
        return "/";
    }

    public void validarU(FacesContext context, UIComponent toValidate, Object value) {
        String usuario = (String) value;
        FacesMessage mensaje;
        if (usuario.length() == 0) {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "info", "Ingrese un usuario valido");
            context.addMessage(toValidate.getClientId(context), mensaje);
            ((UIInput) toValidate).setValid(false);
        }
    }

    public void validarP(FacesContext context, UIComponent toValidate, Object value) {
        String pass = (String) value;
        FacesMessage mensaje;
        if (pass.length() < 5) {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "info", "Ingrese una contraseña valida");
            context.addMessage(toValidate.getClientId(context), mensaje);
            ((UIInput) toValidate).setValid(false);
        }
    }

    public void validarG(FacesContext context, UIComponent toValidate, Object value) {
       String dato = (String)value;
       FacesMessage mensaje;
       if(dato.length() == 0){
           mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Dato", "Este campo se encuentra vacio");
           context.addMessage(toValidate.getClientId(context), mensaje);
           ((UIInput)toValidate).setValid(false);
       }
    }

    /*
    public int buscarU(Usuario u){
       if(lnUsuario.existeUU(u) != null){
           this.usuario = lnUsuario.existeUU(u);
           return usuario.getIdUsuario();
       }
       return 0;
    }
     */
}
