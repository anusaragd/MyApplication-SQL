package com.example.masters.myapplication.TestSQL;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.masters.myapplication.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

//public class Main2Activity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//    }
//}

public class Main2Activity extends Activity {
    SQLiteDatabase mDb;
    MyDbHelper mHelper;
    Cursor mCursor;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);

        checkDatabase();

        ListView listView1 = (ListView)findViewById(R.id.listView1);
        ArrayList<String> dirArray = new ArrayList<String>();

        mHelper = new MyDbHelper(this);
        mDb = mHelper.getWritableDatabase();
        mCursor = mDb.rawQuery("SELECT * FROM " + MyDbHelper.TABLE_NAME, null);
        mCursor.moveToFirst();
        while(!mCursor.isAfterLast()){
            dirArray.add("Name : "
                    + mCursor.getString(mCursor.getColumnIndex(MyDbHelper.COL_NAME))
                    + "\nPiece Price : "
                    + mCursor.getString(mCursor.getColumnIndex(MyDbHelper.COL_PIECE_PRICE))
                    + "\nCake Price"
                    + mCursor.getString(mCursor.getColumnIndex(MyDbHelper.COL_CAKE_PRICE)));
            mCursor.moveToNext();
        }

        ArrayAdapter<String> adapterDir = new ArrayAdapter<String>(getApplicationContext()
                , android.R.layout.simple_list_item_1, dirArray);
        listView1.setAdapter(adapterDir);
    }

    public void checkDatabase() {
        String url = "/data/data/" + getPackageName() + "/databases/BTS";
        File f = new File(url);
        if(!f.exists()) {
            try {
                mHelper = new MyDbHelper(this);
                mDb = mHelper.getWritableDatabase();
                mDb.close();
                mHelper.close();
                InputStream in = getAssets().open("BTS");
                OutputStream out = new FileOutputStream(url);
                byte[] buffer = new byte[in.available()];
                in.read(buffer);
                out.write(buffer, 0, buffer.length);
                in.close();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onPause() {
        super.onPause();
        mHelper.close();
        mDb.close();
    }
}