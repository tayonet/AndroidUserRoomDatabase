package com.example.userroomdatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.userroomdatabase.entities.UserEntity;


public class DeleteUserFragment extends Fragment {


    Button button;
    EditText user_id;
    public DeleteUserFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);
        button = view.findViewById(R.id.button);
        user_id = view.findViewById(R.id.delete_user_id);


        // create the button click event listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string_id = user_id.getText().toString();
                if(!TextUtils.isEmpty(string_id)) {
                    int id = Integer.parseInt(string_id);
                    // create an object of UserEntity and set the id to the one entered in the field
                    UserEntity user = new UserEntity();
                    user.setId(id);
                    // delete the user using the database object from the MainActivity class
                    MainActivity.userDatabase.userDao().deleteUser(user);
                    Toast.makeText(getContext(),"User deleted successfully.",Toast.LENGTH_LONG).show();
                    user_id.setText("");
                } else {
                    Toast.makeText(getContext(),"Insert a valid id.",Toast.LENGTH_LONG).show();
                }


            }
        });

        return view;
    }
}