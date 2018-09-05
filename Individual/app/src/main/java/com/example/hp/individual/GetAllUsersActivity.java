package com.example.hp.individual;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
public class GetAllUsersActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<UserModel> userModelArrayList;
    private CustomAdapter customAdapter;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_users);  //show lyout
        listView = (ListView) findViewById(R.id.lv);      ////get by id list view page

        dbHelper = new DBHelper(this);          /// run the data

        userModelArrayList = dbHelper.getAllUser();

        customAdapter = new CustomAdapter(this,userModelArrayList);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                                            ////Toast id /////////
                Toast.makeText(getApplicationContext(),String.valueOf(userModelArrayList.get(position).getId()),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(GetAllUsersActivity.this,UpdateDeleteActivity.class);     ///run UpdadateDelete class
                intent.putExtra("user",userModelArrayList.get(position).getId());
                startActivity(intent);
            }
        });

    }
}
