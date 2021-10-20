package com.example.userroomdatabase.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userroomdatabase.R;
import com.example.userroomdatabase.entities.UserEntity;

import java.util.List;


public class UserRecyclerAdapter  extends RecyclerView.Adapter<UserRecyclerAdapter.UserViewHolder>{
    // create a list of UserEntity
    List<UserEntity> userEntityList;
    // create a constructor for the adapter
    public UserRecyclerAdapter(List<UserEntity> userList) {
        this.userEntityList = userList;
    }
    @NonNull
    @Override
    public UserRecyclerAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      // inflate the row item
       View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row_item,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserRecyclerAdapter.UserViewHolder holder, int position) {
        //UserEntity userEntity = userEntityList.get(position);
        holder.user_id.setText(" "+userEntityList.get(position).getId());
        holder.user_email.setText(userEntityList.get(position).getEmail());
        holder.user_name.setText(userEntityList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return userEntityList.size();
    }

     class UserViewHolder  extends RecyclerView.ViewHolder{
        TextView user_id,user_name,user_email;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            user_id = itemView.findViewById(R.id.id);
            user_name = itemView.findViewById(R.id.name);
            user_email = itemView.findViewById(R.id.email);
        }
    }
}
