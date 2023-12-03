/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package log_neg;

import acceso_datos.TutorFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Tutor;

/**
 *
 * @author ale_j
 */
@Stateless
@LocalBean
public class LnTutor {

    @EJB
    private TutorFacade tutorF;
    
    public void registrar(Tutor tutor){
        tutorF.create(tutor);
    }
    public List<Tutor> tutores(){
        return tutorF.findAll();
    }
    
    
}
