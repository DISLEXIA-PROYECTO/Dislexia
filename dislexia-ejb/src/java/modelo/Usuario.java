/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ale_j
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByUsuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByApellidop", query = "SELECT u FROM Usuario u WHERE u.apellidop = :apellidop"),
    @NamedQuery(name = "Usuario.findByApellidom", query = "SELECT u FROM Usuario u WHERE u.apellidom = :apellidom"),
    @NamedQuery(name = "Usuario.findByContrasenia", query = "SELECT u FROM Usuario u WHERE u.contrasenia = :contrasenia"),
    @NamedQuery(name = "Usuario.findByDescripcion", query = "SELECT u FROM Usuario u WHERE u.descripcion = :descripcion"),
    @NamedQuery(name = "Usuario.findByFechanac", query = "SELECT u FROM Usuario u WHERE u.fechanac = :fechanac"),
    @NamedQuery(name = "Usuario.findByGrupo", query = "SELECT u FROM Usuario u WHERE u.grupo = :grupo")})
public class Usuario implements Serializable {

    @Size(max = 30)
    @Column(name = "USUARIO")
    private String usuario;
    @Size(max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 30)
    @Column(name = "APELLIDOP")
    private String apellidop;
    @Size(max = 30)
    @Column(name = "APELLIDOM")
    private String apellidom;
    @Size(max = 30)
    @Column(name = "CONTRASENIA")
    private String contrasenia;
    @Size(max = 400)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 15)
    @Column(name = "GRUPO")
    private String grupo;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
    @Column(name = "FECHANAC")
    @Temporal(TemporalType.DATE)
    private Date fechanac;
    @OneToMany(mappedBy = "idtutorado")
    private List<Tutor> tutorList;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }


    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }


    @XmlTransient
    public List<Tutor> getTutorList() {
        return tutorList;
    }

    public void setTutorList(List<Tutor> tutorList) {
        this.tutorList = tutorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Usuario[ idUsuario=" + idUsuario + " ]";
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
}
