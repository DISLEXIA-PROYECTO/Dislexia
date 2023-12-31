/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_datos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Tutor;

/**
 *
 * @author ale_j
 */
@Stateless
public class TutorFacade extends AbstractFacade<Tutor> {

    @PersistenceContext(unitName = "dislexia-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TutorFacade() {
        super(Tutor.class);
    }
    
}
