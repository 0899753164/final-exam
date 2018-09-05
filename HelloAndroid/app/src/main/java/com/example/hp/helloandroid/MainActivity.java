package com.example.hp.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import  com.example.hp.helloandroid.DBHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper db = new DBHelper(this, null, null, 0);
        db.getWritableDatabase();
        Toast.makeText(MainActivity.this, "สร้างฐานข้อมูลเรียบร้อยแล้ว",Toast.LENGTH_LONG).show();

        final EditText edtInput = (EditText) findViewById(R.id.edtInput);
        Button cmdCheck = (Button) findViewById(R.id.cmdCheck);
        final TextView tvOutput = (TextView) findViewById(R.id.tvOutput);

        if (cmdCheck != null) {
            cmdCheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (edtInput.getText().toString().trim() != "") {
                        tvOutput.setText(edtInput.getText());
                    }

                    Toast.makeText(MainActivity.this, "อ่านข้อมูลเรียบร้อยแล้ว", Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}