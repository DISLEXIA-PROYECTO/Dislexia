/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_datos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import modelo.Usuario;

/**
 *
 * @author ale_j
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "dislexia-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
        public Usuario usuarioId(int id){
        try{
         TypedQuery<Usuario> consulta = em.createQuery(
                 "Select u from Usuario u where u.idUsuario = :idUser", Usuario.class);
         consulta.setParameter("idUser", id);
            return consulta.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
        
        public Usuario usuarioBusqueda(String usuario){
        try{
            System.out.println("Dentro del método");
         TypedQuery<Usuario> consulta = em.createQuery(
                 "Select u from Usuario u where u.usuario = :userName", Usuario.class);
         consulta.setParameter("userName", usuario);
            return consulta.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
    
        public Usuario usuario(String usuario, String contrasenia){
        try{
         TypedQuery<Usuario> consulta = em.createQuery(
                 "Select u from Usuario u where u.usuario = :user and u.contrasenia = :contrasenia", Usuario.class);
         consulta.setParameter("user", usuario);
         consulta.setParameter("contrasenia",contrasenia);
            return consulta.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
}
