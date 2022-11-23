package pe.edu.utp.entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pe.edu.utp.entity.Rol;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-22T21:57:32", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Permiso.class)
public class Permiso_ { 

    public static volatile SingularAttribute<Permiso, String> name;
    public static volatile SingularAttribute<Permiso, String> description;
    public static volatile SingularAttribute<Permiso, String> id;
    public static volatile SingularAttribute<Permiso, Integer> orden;
    public static volatile ListAttribute<Permiso, Rol> rolList;
    public static volatile SingularAttribute<Permiso, Character> status;

}