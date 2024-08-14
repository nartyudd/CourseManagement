package com.dht.pojo;

import com.dht.pojo.Course;
import com.dht.pojo.Profile;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-14T13:27:20")
@StaticMetamodel(Certificate.class)
public class Certificate_ { 

    public static volatile SingularAttribute<Certificate, Profile> profileId;
    public static volatile SingularAttribute<Certificate, String> name;
    public static volatile SingularAttribute<Certificate, Integer> id;
    public static volatile SingularAttribute<Certificate, Course> courseId;
    public static volatile SingularAttribute<Certificate, String> content;
    public static volatile SetAttribute<Certificate, Profile> profileSet;

}