/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package adm;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author DamianBautista
 */
@Named(value = "calculos")
@SessionScoped
public class Calculos implements Serializable {

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private int grado;
    private String grupo;
    private String correoElectronico;
    private double calificacionActividad1;
    private double calificacionActividad2;
    private String problemas;
    

    /**
     * Creates a new instance of Calculos
     */
    public Calculos() {

    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
    public double getCalificacionActividad1() {
        return calificacionActividad1;
    }

    public void setCalificacionActividad1(double calificacionActividad1) {
        this.calificacionActividad1 = calificacionActividad1;
    }
    
    public double getCalificacionActividad2() {
        
        return calificacionActividad2;
    }

    public void setCalificacionActividad2(double calificacionActividad2) {
        this.calificacionActividad2 = calificacionActividad2;
    }

    public double promedio() {
        Double x = calificacionActividad1 + calificacionActividad2;
        return x / 2;
    }

    public String getFechaNacimientoFormatted() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", new Locale("es", "ES"));
        return sdf.format(fechaNacimiento);
    }

    public String getProblemas() {
        return problemas;
    }

    public void setProblemas(String problemas) {
        this.problemas = problemas;
        
    }

}
