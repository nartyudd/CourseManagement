/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dht.repository;

import com.dht.pojo.Account;

/**
 *
 * @author admin
 */
public interface UserRepository {
    Account getUserByUsername(String username);
    boolean authUser(String username, String password);
    Account addUser(Account user);
}
