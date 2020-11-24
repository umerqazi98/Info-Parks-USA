package com.CS440.infoparksusa;

import java.util.HashMap;

public class UserDatabase {
    private HashMap<String, User> userTable;

    public UserDatabase(){
        userTable = new HashMap<String , User>();
    }

    public boolean addUser (User userObject){
        String key = userObject.getEmail();
        if (!userTable.containsKey(key)){
            userTable.put(key,userObject);
            return true;
        }
        return false;
    }

    public boolean removeUser(String key){
        if (userTable.containsKey(key)){
            userTable.remove(key);
            return true;
        }
        return false;

    }

    public User getUSer(String key) {
        return userTable.get(key);
    }

    public boolean changePassword(String key, String newPassword){
        if (userTable.containsKey(key)){
            User user = userTable.get(key);
            user.changePassword(newPassword);
            return true;
        }
        return false;
    }


}
