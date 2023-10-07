package com.devphics.roomdb_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import com.devphics.roomdb_practice.DB_Table_Model_Or_EntityClass.User;
import com.devphics.roomdb_practice.DataBase.AppDatabase;
import com.devphics.roomdb_practice.Interface.UserDAO;

import java.util.List;

public class fetchdata extends AppCompatActivity {

    RecyclerView recView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetchdata);


        getroomdata();

    }

    private void getroomdata() {

        AppDatabase db = Room. databaseBuilder(getApplicationContext(),
                AppDatabase. class,"room_db") .allowMainThreadQueries().build();
        UserDAO userDao = db.userDao();


        recView = findViewById(R.id.recview);
        recView.setLayoutManager(new LinearLayoutManager(this));

        List<User> users  =userDao.getallusers();
        myadapter myadapter=new myadapter(users);
        recView.setAdapter(myadapter);


    }
}