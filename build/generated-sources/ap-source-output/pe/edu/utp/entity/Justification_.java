package pe.edu.utp.entity;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pe.edu.utp.entity.Schedule;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-22T21:57:32", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Justification.class)
public class Justification_ { 

    public static volatile SingularAttribute<Justification, Date> date;
    public static volatile SingularAttribute<Justification, String> reason;
    public static volatile SingularAttribute<Justification, String> file;
    public static volatile SingularAttribute<Justification, String> description;
    public static volatile SingularAttribute<Justification, Integer> id;
    public static volatile SingularAttribute<Justification, Schedule> idShedule;

}