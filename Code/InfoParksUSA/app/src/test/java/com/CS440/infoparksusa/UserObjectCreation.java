package com.CS440.infoparksusa;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class UserObjectCreation {
    //Creation of user Object with String for the
    User user;

    @Before
    public void initTest(){
        try {
            user = new User("cj", "1111 W Park", "1","cjimen25@uic.edu","1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }



}
