package pe.edu.utp.entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pe.edu.utp.entity.Employe;
import pe.edu.utp.entity.Permiso;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-22T21:57:32", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile ListAttribute<Rol, Employe> employeList;
    public static volatile SingularAttribute<Rol, String> name;
    public static volatile SingularAttribute<Rol, Integer> id;
    public static volatile ListAttribute<Rol, Permiso> permisoList;
    public static volatile SingularAttribute<Rol, Character> status;

}