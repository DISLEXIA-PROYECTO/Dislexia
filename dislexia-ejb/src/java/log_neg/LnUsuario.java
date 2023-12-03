/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package log_neg;

import acceso_datos.UsuarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Usuario;

/**
 *
 * @author ale_j
 */
@Stateless
@LocalBean
public class LnUsuario {

    @EJB
    private UsuarioFacade usuarioF;
    
    public void registrar(Usuario user){
        usuarioF.create(user);
    }
    
    public List<Usuario> usuarios(){
        return usuarioF.findAll();
    }
    
    public Usuario usuarioLog(String name, String pass){
        return usuarioF.usuario(name,pass);
    }
    
    public Usuario existeUID(int id){
        return usuarioF.usuarioId(id);
    }
    
    public Usuario existeUU(String u){
        return usuarioF.usuarioBusqueda(u);
    }
    
}
