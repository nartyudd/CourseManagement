package com.dht.pojo;

import com.dht.pojo.Account;
import com.dht.pojo.Profile;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-08-14T13:27:20")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile SingularAttribute<Role, String> name;
    public static volatile SetAttribute<Role, Account> accountSet;
    public static volatile SingularAttribute<Role, Integer> id;
    public static volatile SetAttribute<Role, Profile> profileSet;

}