package com.devphics.roomdb_practice;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.devphics.roomdb_practice.DB_Table_Model_Or_EntityClass.User;
import com.devphics.roomdb_practice.DataBase.AppDatabase;
import com.devphics.roomdb_practice.Interface.UserDAO;

import java.util.List;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {


    List<User> users;

    public myadapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign, parent, false);
        return new myviewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        holder.recid.setText(String.valueOf(users.get(position).getUid()));
        holder.recfname.setText(users.get(position).getFirstName());
        holder.reclname.setText(users.get(position).getLastName());
        holder.delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                AppDatabase db = Room.databaseBuilder(holder.recfname.getContext(),
                        AppDatabase.class, "room_db").allowMainThreadQueries().build();

                UserDAO userDao = db.userDao();
// this is to delete the record from room database
                userDao.deleteById(users.get(adapterPosition).getUid());
// this is to delete the record from Array List which is the source of recview data
                users.remove(adapterPosition);
//update the fresh list of ArrayList data to re
                notifyDataSetChanged();

            }
        });

        //last video
        holder.edbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(holder.edbtn.getContext(), updatedata.class);
                intent.putExtra("uid",String.valueOf(users.get(position).getUid()));
                intent.putExtra("ufname",users.get(position).getFirstName());
                intent.putExtra("ulname",users.get(position).getLastName());
                holder.edbtn.getContext().startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {
        TextView recid, recfname, reclname;

        ImageButton delbtn,edbtn;

        public myviewholder(View itemView) {
            super(itemView);

            recid = itemView.findViewById(R.id.recid);
            recfname = itemView.findViewById(R.id.recfname);
            reclname = itemView.findViewById(R.id.reclname);
            delbtn = itemView.findViewById(R.id.delbtn);
            edbtn = itemView.findViewById(R.id.edbtn);

        }
    }


}
