package com.CS440.infoparksusa;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDatabaseUnitTest {
    User user, user1, user2;

    UserDatabase database = new UserDatabase();

    @Before
    public void init() {
        try {
            user = new User("cj", "1111 W Park", "3129876547", "cj@uic.edu", "c1234");
            user1 = new User("tom", "25 Circle", "7862239374", "tom@uic.edu", "d1234");
            user2 = new User("linda", "78 E Lane", "9874563245", "linda@uic.edu", "l1234");


        } catch (Exception e) {
            e.toString();
        }
        database.addUser(user);
        database.addUser(user1);
        database.addUser(user2);

    }

    @Test
    public void getUserObject(){
        User userCopy = database.getUSer("cj@uic.edu");
        assertEquals(userCopy, user);
    }

    //    Test for unique key in the user database, expected return = false;
    @Test
    public void uniqueKey() {
        boolean addUser = database.addUser(user);
        assertFalse(addUser);
    }

    //    Test for insertion of user into database, expected return = true;
    @Test
    public void isUserAdded() {
        try {
            User user4 = new User("diana", "34 Luty", "918763273", "diana@uic.edu", "d1234");
            database.addUser(user4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(true, database.contains("diana@uic.edu"));
    }

    //    Test to see if a user was remove from the database
    @Test
    public void removeUser() {
        assertTrue(database.contains("tom@uic.edu"));
        database.removeUser("tom@uic.edu");
        boolean result = database.contains("tom@uic.edu");
        assertFalse(result);

    }

    //    Test for changing a password
    @Test
    public void passwordChange() {
        assertTrue(database.contains("cj@uic.edu"));
        assertTrue(database.changePassword("cj@uic.edu", "cj4567"));
        assertEquals("cj4567", user.getPassword());

    }
}
