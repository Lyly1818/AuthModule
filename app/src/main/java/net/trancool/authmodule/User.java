package net.trancool.authmodule;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class User implements Serializable {

    String uId;
    String email;
    String password;
    boolean isConnected;
    Date dateCreated;

    User(){
        this.uId = uId;
        this.email = email;
        this.password = password;
    }

    User(String email, String password) {
        this.uId = uId;
        this.email = email;
        this.password = password;
    }




}
