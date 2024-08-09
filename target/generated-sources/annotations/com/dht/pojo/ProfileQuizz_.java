package com.dht.pojo;

import com.dht.pojo.Profile;
import com.dht.pojo.ProfileQuizzPK;
import com.dht.pojo.Quizz;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-09T05:08:08")
@StaticMetamodel(ProfileQuizz.class)
public class ProfileQuizz_ { 

    public static volatile SingularAttribute<ProfileQuizz, Profile> profile;
    public static volatile SingularAttribute<ProfileQuizz, Quizz> quizz;
    public static volatile SingularAttribute<ProfileQuizz, ProfileQuizzPK> profileQuizzPK;
    public static volatile SingularAttribute<ProfileQuizz, Boolean> isCompleted;

}