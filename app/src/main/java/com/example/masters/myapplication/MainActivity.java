package com.example.masters.myapplication;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
//import android.support.v7.app.ActionBarActivity;
import android.database.Cursor;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    DBHelper mHelper;
    List<String> friends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] lists = {"aaaaa ","sssss","aasas","rerere","ttttt","yyyyy","aaaaa ","sssss",
                "aasas","rerere","ttttt","yyyyy","aaaaa ","sssss","aasas","rerere","ttttt",
                "yyyyy","aaaaa ","sssss","aasas","rerere","ttttt","yyyyy","aaaaa ","sssss",
                "aasas","rerere","ttttt","yyyyy","aaaaa ","sssss","aasas","rerere","ttttt",
                "yyyyy","aaaaa ","sssss","aasas","rerere","ttttt","yyyyy","aaaaa ","sssss",
                "aasas","rerere","ttttt","yyyyy","aaaaa ","sssss","aasas","rerere","ttttt",
                "yyyyy","aaaaa ","sssss","aasas","rerere","ttttt","yyyyy","aaaaa ","sssss",
                "aasas","rerere","ttttt","yyyyy"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lists);
        setListAdapter(adapter);

//        mHelper = new DBHelper(this);
//        friends = mHelper.getFriendList();

////        String adapter[] = {"a","s"};
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, friends);
//        setListAdapter(adapter);
    }


}

