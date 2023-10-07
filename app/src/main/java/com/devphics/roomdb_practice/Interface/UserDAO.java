package com.devphics.roomdb_practice.Interface;

import androidx.room.Dao;

import androidx.room.Insert;
import androidx.room.Query;


import com.devphics.roomdb_practice.DB_Table_Model_Or_EntityClass.User;

import java.util.List;

@Dao
public interface UserDAO {

//1st
    @Insert
    void insertRecord(User users);

//2nd,3rd and 4th
   @Query("SELECT EXISTS(SELECT * FROM User WHERE uid = :userId)")
    Boolean is_exist(int userId);

//3rd and 4th
   @Query("SELECT * FROM User")
    List<User> getallusers();


   //5th
    @Query("DELETE FROM User WHERE uid = :id")
    void deleteById(int id);


    //last video
    @Query("UPDATE User SET first_name = :fname,last_name = :lname WHERE uid= :id")
    void updateById(int id,String fname,String lname);

}