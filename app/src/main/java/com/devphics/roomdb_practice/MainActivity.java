package com.devphics.roomdb_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.devphics.roomdb_practice.DB_Table_Model_Or_EntityClass.User;
import com.devphics.roomdb_practice.DataBase.AppDatabase;
import com.devphics.roomdb_practice.Interface.UserDAO;

public class MainActivity extends AppCompatActivity {

    EditText t1, t2, t3;
    Button b1,b2;
    TextView lbl,data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        t3 = findViewById(R.id.t3);

        data=findViewById(R.id.dataholder);
        lbl = findViewById(R.id.lbl);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // 1st video
                // new backgroundThread().start();

// 2nd,3rd and 4th video
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "room_db").allowMainThreadQueries().build();
                UserDAO userDao = db.userDao();
                Boolean check = userDao.is_exist(Integer.parseInt(t3.getText().toString()));
                if (check == false) {
                    userDao.insertRecord(new User(Integer.parseInt(t3.getText().toString()), t2.getText().toString(), t1.getText().toString()));
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    lbl.setText("Inserted successfully");

                } else {

//                    t1.setText("");
//                    t2.setText("");
                    t3.setText("");
                    lbl.setText("Already exist");

                }


            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



// 3nd video
//                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
//                        AppDatabase.class,"room_db").allowMainThreadQueries().build();
//                UserDAO userDAO = db.userDao();
//
//                List<User> users=userDAO.getallusers();
//                String str="";
//                for (User user : users)
//                    str=str+"\t\t "+user.getUid()+"   "+user.getFirstName()+"   "+user.getLastName()+"\n\n";
//
//                data.setText(str);


                //4th video
                startActivities(new Intent[]{new Intent(getApplicationContext(), fetchdata.class)});


            }
        });

    }




//  1st video
//    class backgroundThread extends Thread {
//        public void run(){
//            super.run();
//            AppDatabase db = Room.databaseBuilder(getApplicationContext(),
//                    AppDatabase.class, "room_db").build();
//
//            UserDAO userDao = db.userDao();
//            userDao.insertRecord(new User(11,t1.getText().toString(),t2.getText().toString()));
//            t1.setText("");
//            t2.setText("");
//
//        }
//
//    }
}

