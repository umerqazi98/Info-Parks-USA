package com.CS440.infoparksusa;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserAddedToDataBase {
    User user, user1, user2;

    UserDatabase database = new UserDatabase();

    @Before
    public void init(){
        try {
            user = new User("cj", "1111 W Park", "3129876547","cj@uic.edu","c1234");
            user1 = new  User("tom","25 Circle","7862239374", "tom@uic.edu", "d1234");
            user2 = new  User("linda", "78 E Lane", "9874563245", "linda@uic.edu", "l1234");


        } catch (Exception e) {
            e.toString();
        }
        database.addUser(user);
        database.addUser(user1);
        database.addUser(user2);

    }

    @Test
    public void addedToDatabase(){
        boolean addUser = database.addUser(user);
        assertEquals(false, addUser);
    }
}
