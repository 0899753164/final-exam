package com.example.hp.individual;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); //show page 2

        Button buttonAdd = (Button) findViewById(R.id.Addbutton); //set button by id
        buttonAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(getApplicationContext(),Three.class); //set page 2 to 3
                startActivity(i2);

            }
        });

        //////////////////View data Button ////////////////////////////
        Button buttonView = (Button) findViewById(R.id.Viewbutton); //set button by id
        buttonView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(getApplicationContext(),GetAllUsersActivity.class); //set page 2 to GetAllUsersActivity
                startActivity(i3);
            }
        });

    }
}










