package pe.edu.utp.entity;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pe.edu.utp.entity.CargoPersonal;
import pe.edu.utp.entity.Rol;
import pe.edu.utp.entity.Schedule;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-22T21:57:32", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Employe.class)
public class Employe_ { 

    public static volatile SingularAttribute<Employe, Rol> idRol;
    public static volatile SingularAttribute<Employe, String> address;
    public static volatile SingularAttribute<Employe, Character> sex;
    public static volatile SingularAttribute<Employe, String> numberDocument;
    public static volatile SingularAttribute<Employe, CargoPersonal> idCargo;
    public static volatile SingularAttribute<Employe, String> password;
    public static volatile SingularAttribute<Employe, Character> flagAccess;
    public static volatile SingularAttribute<Employe, String> codeEmployee;
    public static volatile SingularAttribute<Employe, String> names;
    public static volatile ListAttribute<Employe, Schedule> scheduleList;
    public static volatile SingularAttribute<Employe, String> phone;
    public static volatile SingularAttribute<Employe, Date> dateStart;
    public static volatile SingularAttribute<Employe, String> lastNames;
    public static volatile SingularAttribute<Employe, String> typeDocument;
    public static volatile SingularAttribute<Employe, Integer> id;
    public static volatile SingularAttribute<Employe, Date> dateBirth;
    public static volatile SingularAttribute<Employe, String> user;
    public static volatile SingularAttribute<Employe, String> email;
    public static volatile SingularAttribute<Employe, Character> status;

}