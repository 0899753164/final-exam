package com.example.hp.individual;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    ///////////////////////////////////////////////////////////////////////////
        requestWindowFeature(Window.FEATURE_NO_TITLE);   /////NO title,Action
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main); //show page 1
    ////////////////////////////////////////////////////////////////////////////

        Button button = (Button) findViewById(R.id.Nextbutton); //set button by id
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),second.class); //set page 1 to 2
                startActivity(i);
            }
        });
    }
}
