/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package Clases;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author ale_j
 */
@Named(value = "usuarios")
@SessionScoped
public class Usuarios implements Serializable {

    /**
     * Creates a new instance of Usuarios
     */
    public Usuarios() {
    }
    
    private int id;
    private String usuario;
    private String correoElectronico;
    private String contrasena;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsuario(){
    return usuario;
   }
    
    public void setUsuario(String Usuario){
    this.usuario = Usuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    }


    

