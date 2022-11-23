package pe.edu.utp.entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pe.edu.utp.entity.CargoPersonal;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-22T21:57:32", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Area.class)
public class Area_ { 

    public static volatile SingularAttribute<Area, String> name;
    public static volatile SingularAttribute<Area, String> description;
    public static volatile ListAttribute<Area, CargoPersonal> cargoPersonalList;
    public static volatile SingularAttribute<Area, Integer> id;
    public static volatile SingularAttribute<Area, Character> status;

}