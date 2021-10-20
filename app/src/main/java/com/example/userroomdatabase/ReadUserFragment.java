package com.example.userroomdatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.userroomdatabase.adapter.UserRecyclerAdapter;
import com.example.userroomdatabase.database.UserDatabase;
import com.example.userroomdatabase.entities.UserEntity;

import java.util.List;

import static android.content.ContentValues.TAG;


public class ReadUserFragment extends Fragment {

    RecyclerView recyclerView;
    UserRecyclerAdapter userRecyclerAdapter;
    List<UserEntity> userEntityList;

    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // poppulate userEntityList with users from the Room database using the database object
        userEntityList  = MainActivity.userDatabase.userDao().getUsers();
        // pass in the userEntityList to the userRecyclerAdapter as an argument for its constructor
       // Log.d(TAG, "onCreateView: "+userEntityList.get(0).getName()+" and "+userEntityList.get(1).getName());
        userRecyclerAdapter = new UserRecyclerAdapter(userEntityList);

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_read_user, container, false);
        // get the id of the recycler view
        recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        // set up divider for the recyclerview
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(userRecyclerAdapter);
        return view;

    }
}