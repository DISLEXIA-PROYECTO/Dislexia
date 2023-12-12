/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package adm;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    private Calendar cal;
    private Date fechaSeleccionada;
    private Date fechaMinima;
    private Date fechaMaxima;

    public cUsuarios() {
        usuario = new Usuario();
        cal = Calendar.getInstance();
        fechaMaxima = cal.getTime();
    }

    public Date getFechaSeleccionada() {
        return fechaSeleccionada;
    }

    public void setFechaSeleccionada(Date fechaSeleccionada) {
        this.fechaSeleccionada = fechaSeleccionada;
    }

    public Date getFechaMinima() {
        return fechaMinima;
    }

    public void setFechaMinima(Date fechaMinima) {
        this.fechaMinima = fechaMinima;
    }

    public Date getFechaMaxima() {
        return fechaMaxima;
    }

    public void setFechaMaxima(Date fechaMaxima) {
        this.fechaMaxima = fechaMaxima;
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

    public List<Usuario> getUsuarios() {
        return lnUsuario.usuarios();
    }

    public String log() {
        String us = usuario.getUsuario();
        String pass = usuario.getContrasenia();
        FacesMessage mensaje;
        if (lnUsuario.usuarioLog(us, pass) != null) {          
            return "actividades";
        }
            return "login"; 
        
    }

    public void validarU(FacesContext context, UIComponent toValidate, Object value) {
        String usuario = (String) value;
        FacesMessage mensaje;
        if (usuario.length() == 0) {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "info", "Ingrese un usuario valido");
            context.addMessage(toValidate.getClientId(context), mensaje);
            ((UIInput) toValidate).setValid(false);
            return;
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
        String dato = (String) value;
        String regex = "^[a-zA-Z]+$";
        Pattern patron = Pattern.compile(regex);
        Matcher matcher = patron.matcher(dato);

        FacesMessage mensaje;

        if (!matcher.find()) {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Algunos campos contienen números", "El campo solo requiere de texto sin números o caracteres especiales");
            context.addMessage(toValidate.getClientId(context), mensaje);
            ((UIInput) toValidate).setValid(false);
            return;
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
