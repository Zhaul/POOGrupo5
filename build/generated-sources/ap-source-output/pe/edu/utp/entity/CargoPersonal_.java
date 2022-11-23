package pe.edu.utp.entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pe.edu.utp.entity.Area;
import pe.edu.utp.entity.Employe;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-22T21:57:32", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(CargoPersonal.class)
public class CargoPersonal_ { 

    public static volatile SingularAttribute<CargoPersonal, Area> idArea;
    public static volatile ListAttribute<CargoPersonal, Employe> employeList;
    public static volatile SingularAttribute<CargoPersonal, String> name;
    public static volatile SingularAttribute<CargoPersonal, String> description;
    public static volatile SingularAttribute<CargoPersonal, Integer> id;
    public static volatile SingularAttribute<CargoPersonal, Character> status;

}