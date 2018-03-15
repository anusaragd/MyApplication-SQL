package com.example.masters.myapplication;

import android.provider.BaseColumns;

/**
 * Created by MASTERS on 13/3/2561.
 */

public class Friend {

    private int id;
    private String firstName;
    private String lastName;
    private String tel;
    private String email;
    private String description;

    //Database
    public static final String DATABASE_NAME = "devahoy_friends.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE = "friend";

    public class Column {
        public static final String ID = BaseColumns._ID;
        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
        public static final String TEL = "tel";
        public static final String EMAIL = "email";
        public static final String DESCRIPTION = "description";
    }

    //Default Constructor
    public Friend() {

        String CREATE_FRIEND_TABLE = String.format("CREATE TABLE %s " +
                        "(%s INTEGER PRIMARY KEY  AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)",
                Friend.TABLE,
                Friend.Column.ID,
                Friend.Column.FIRST_NAME,
                Friend.Column.LAST_NAME,
                Friend.Column.TEL,
                Friend.Column.EMAIL,
                Friend.Column.DESCRIPTION);


    }
    //Constructor
    public Friend(int id, String firstName, String lastName, String tel,
                  String email, String description) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
        this.email = email;
        this.description = description;

    }

    //Getter, Setter
}
