package com.devphics.roomdb_practice.DataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.devphics.roomdb_practice.DB_Table_Model_Or_EntityClass.User;
import com.devphics.roomdb_practice.Interface.UserDAO;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDAO userDao();
}