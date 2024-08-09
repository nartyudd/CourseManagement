package com.dht.pojo;

import com.dht.pojo.Category;
import com.dht.pojo.Certificate;
import com.dht.pojo.FeedBack;
import com.dht.pojo.Lesson;
import com.dht.pojo.Notify;
import com.dht.pojo.Profile;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-09T05:08:08")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, Date> updateDate;
    public static volatile SingularAttribute<Course, Date> createdDate;
    public static volatile SetAttribute<Course, Lesson> lessonSet;
    public static volatile SetAttribute<Course, Notify> notifySet;
    public static volatile SingularAttribute<Course, Category> cateId;
    public static volatile SingularAttribute<Course, String> name;
    public static volatile SetAttribute<Course, Certificate> certificateSet;
    public static volatile SetAttribute<Course, FeedBack> feedBackSet;
    public static volatile SingularAttribute<Course, Integer> id;
    public static volatile SingularAttribute<Course, Date> expirateDate;
    public static volatile SetAttribute<Course, Profile> profileSet;

}