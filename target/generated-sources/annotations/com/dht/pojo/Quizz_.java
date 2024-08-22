package com.dht.pojo;

import com.dht.pojo.Lesson;
import com.dht.pojo.ProfileQuizz;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-17T12:23:41")
@StaticMetamodel(Quizz.class)
public class Quizz_ { 

    public static volatile SingularAttribute<Quizz, BigDecimal> score;
    public static volatile SetAttribute<Quizz, ProfileQuizz> profileQuizzSet;
    public static volatile SingularAttribute<Quizz, Date> updateDate;
    public static volatile SingularAttribute<Quizz, Date> createdDate;
    public static volatile SingularAttribute<Quizz, Lesson> lessonId;
    public static volatile SingularAttribute<Quizz, Integer> id;
    public static volatile SingularAttribute<Quizz, String> content;

}