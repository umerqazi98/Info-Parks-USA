package com.CS440.infoparksusa;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class UserUnitTest {
    //Creation of user Object with String for the
    User user;

    @Before
    public void initTest(){
        try {
            user = new User("cj", "11 W Park", "123","cjimen25@uic.edu","1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


// Test to check if users phone was properly entered, expected return = "123"
    @Test
    public void checkPhone(){
        assertEquals("123", user.getPhone());
    }

//  Test to check if users name was properly entered, expected return = "cj"
    @Test
    public void checkName() {assertEquals("cj", user.getName());}

//    Test for password change
    @Test
    public void passwordChange(){
        user.changePassword("4567");
        assertEquals("4567", user.getPassword());
    }

    //  Test to check if users address was properly entered, expected return = "1111 W Park"
    @Test
    public void checkAddress() {assertEquals("11 W Park", user.getAddress());}

    //  Test to check if users name was properly entered, expected return = "cj"
    @Test
    public void checkPassword() {assertEquals("1234", user.getPassword());}



}
