package com.dht.pojo;

import com.dht.pojo.Answer;
import com.dht.pojo.Lesson;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-22T14:01:19")
@StaticMetamodel(Question.class)
public class Question_ { 

    public static volatile SingularAttribute<Question, BigDecimal> score;
    public static volatile SetAttribute<Question, Answer> answerSet;
    public static volatile SingularAttribute<Question, Lesson> lessonId;
    public static volatile SingularAttribute<Question, Integer> id;
    public static volatile SingularAttribute<Question, String> content;

}