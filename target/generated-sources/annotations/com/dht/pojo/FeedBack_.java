package com.dht.pojo;

import com.dht.pojo.Account;
import com.dht.pojo.Course;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-14T13:27:20")
@StaticMetamodel(FeedBack.class)
public class FeedBack_ { 

    public static volatile SingularAttribute<FeedBack, Account> accountId;
    public static volatile SingularAttribute<FeedBack, Integer> rating;
    public static volatile SingularAttribute<FeedBack, Integer> id;
    public static volatile SingularAttribute<FeedBack, Course> courseId;
    public static volatile SingularAttribute<FeedBack, String> content;

}