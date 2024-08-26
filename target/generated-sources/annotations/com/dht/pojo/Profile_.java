package com.dht.pojo;

import com.dht.pojo.Account;
import com.dht.pojo.Certificate;
import com.dht.pojo.Course;
import com.dht.pojo.ProfileQuizz;
import com.dht.pojo.Role;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-20T16:45:13")
@StaticMetamodel(Profile.class)
public class Profile_ { 

    public static volatile SetAttribute<Profile, ProfileQuizz> profileQuizzSet;
    public static volatile SingularAttribute<Profile, Account> accountId;
    public static volatile SingularAttribute<Profile, String> phone;
    public static volatile SingularAttribute<Profile, Role> roleId;
    public static volatile SetAttribute<Profile, Certificate> certificateSet;
    public static volatile SingularAttribute<Profile, String> fullName;
    public static volatile SetAttribute<Profile, Course> courseSet;
    public static volatile SingularAttribute<Profile, Integer> id;
    public static volatile SetAttribute<Profile, Certificate> certificateSet1;
    public static volatile SingularAttribute<Profile, String> email;

}