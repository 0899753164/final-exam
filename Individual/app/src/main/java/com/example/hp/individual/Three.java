package com.example.hp.individual;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Three extends AppCompatActivity
{
    private Button btnSave, btnViewall;
    private  EditText etdate, etdrug, etsympton, ettreament;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        //////////////////////////////////////////////////////////////////////
        dbHelper = new DBHelper(this);

        btnSave = (Button) findViewById(R.id.SaveButton);
        btnViewall = (Button) findViewById(R.id.Viewbutton);
//init//
        etdate = (EditText) findViewById(R.id.DateEditText);
        etdrug = (EditText) findViewById(R.id.NDrugEditText);
        etsympton = (EditText) findViewById(R.id.SymptonEditText);
        ettreament = (EditText) findViewById(R.id.TreatEditText);

        ///////////////////////////////listen to save button//////////////////////////////////
         btnSave.setOnClickListener(new OnClickListener() {
             @Override
             public void onClick(View v) {
                                                    ///////////////check input not empty//////////////
                 if (etdate.getText().length() == 0 || etdrug.getText().length() ==0 || etsympton.getText().length() ==0 || ettreament.getText().length() == 0){
                     Toast.makeText(Three.this, "กรุณาป้อนข้อมูลทุกช่อง", Toast.LENGTH_SHORT).show();
                 }else {
                     dbHelper.insertData(etdate.getText().toString(), etdrug.getText().toString(), etsympton.getText().toString(), ettreament.getText().toString());
                     etdate.setText("");
                     etdrug.setText("");
                     etsympton.setText("");
                     ettreament.setText("");
                     Toast.makeText(Three.this, "เพิ่มข้อมูลเรียบร้อยแล้ว", Toast.LENGTH_SHORT).show();
                 }
             }
         });
    }

}
