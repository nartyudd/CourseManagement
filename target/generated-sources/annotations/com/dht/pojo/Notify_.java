package com.dht.pojo;

import com.dht.pojo.Account;
import com.dht.pojo.Course;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-07T23:37:29")
@StaticMetamodel(Notify.class)
public class Notify_ { 

    public static volatile SingularAttribute<Notify, Account> accountId;
    public static volatile SingularAttribute<Notify, String> name;
    public static volatile SingularAttribute<Notify, Integer> id;
    public static volatile SingularAttribute<Notify, Course> courseId;
    public static volatile SingularAttribute<Notify, String> content;

}