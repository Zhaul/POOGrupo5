package pe.edu.utp.entity;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pe.edu.utp.entity.Employe;
import pe.edu.utp.entity.Justification;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-22T21:57:32", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Schedule.class)
public class Schedule_ { 

    public static volatile SingularAttribute<Schedule, Date> dateStart;
    public static volatile SingularAttribute<Schedule, Date> hourStart;
    public static volatile ListAttribute<Schedule, Justification> justificationList;
    public static volatile SingularAttribute<Schedule, Integer> id;
    public static volatile SingularAttribute<Schedule, Employe> idEmploye;
    public static volatile SingularAttribute<Schedule, Date> hourEntry;
    public static volatile SingularAttribute<Schedule, Character> status;

}