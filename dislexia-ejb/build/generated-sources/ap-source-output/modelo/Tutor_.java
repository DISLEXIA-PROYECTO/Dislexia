package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Usuario;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-12-05T00:53:27")
@StaticMetamodel(Tutor.class)
public class Tutor_ { 

    public static volatile SingularAttribute<Tutor, Integer> idTutor;
    public static volatile SingularAttribute<Tutor, String> apellidop;
    public static volatile SingularAttribute<Tutor, String> correo;
    public static volatile SingularAttribute<Tutor, String> apellidom;
    public static volatile SingularAttribute<Tutor, String> nombre;
    public static volatile SingularAttribute<Tutor, Usuario> idtutorado;

}