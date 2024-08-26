package com.dht.pojo;

import com.dht.pojo.Course;
import com.dht.pojo.Question;
import com.dht.pojo.Video;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-26T17:18:16")
@StaticMetamodel(Lesson.class)
public class Lesson_ { 

    public static volatile SingularAttribute<Lesson, Date> updateDate;
    public static volatile SingularAttribute<Lesson, Date> createdDate;
    public static volatile SetAttribute<Lesson, Question> questionSet;
    public static volatile SetAttribute<Lesson, Video> videoSet;
    public static volatile SingularAttribute<Lesson, String> name;
    public static volatile SingularAttribute<Lesson, Integer> id;
    public static volatile SingularAttribute<Lesson, Course> courseId;
    public static volatile SingularAttribute<Lesson, String> content;

}