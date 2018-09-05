package com.example.hp.individual;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDeleteActivity extends AppCompatActivity {

    private UserModel userModel;
    private EditText etdate, etdrug, etsympton, ettreament;
    private Button btnupdate, btndelete;
    private DBHelper dbHelper;
    String id;
    private int receivedGetAlId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);
        Bundle bundle = getIntent().getExtras();
            /////init Editext///////////////
        etdate = (EditText) findViewById(R.id.DateEditText);            ///////date
        etdrug = (EditText) findViewById(R.id.NDrugEditText);           //////drug name
        etsympton = (EditText) findViewById(R.id.SymptonEditText);      /////sympton
        ettreament = (EditText) findViewById(R.id.TreatEditText);       ////treatment

        btnupdate = (Button) findViewById(R.id.btnupdate);              //Button UpDate
        btndelete = (Button) findViewById(R.id.btndelete);              //Button Delete

        dbHelper = new DBHelper(this);    /// run the database///

        receivedGetAlId = bundle.getInt("user");
     //   Toast.makeText(this,(String.valueOf(receivedGetAlId)+"ttttt"),Toast.LENGTH_SHORT).show();
        userModel = dbHelper.getUserModel(receivedGetAlId);
     //   Toast.makeText(this,(String.valueOf(userModel.getId())+"eeeettttt"),Toast.LENGTH_SHORT).show();

        /////////set text//////////////////////////////////
        etdate.setText(userModel.getDate());
        etdrug.setText(userModel.getDrug());
        etsympton.setText(userModel.getSymtop());
        ettreament.setText(userModel.getTreatment());

            ///*********Button delete*****************************
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///////////////check input not empty//////////////
                if (etdate.getText().length() == 0 || etdrug.getText().length() ==0 || etsympton.getText().length() ==0 || ettreament.getText().length() == 0)
                {
                    Toast.makeText(UpdateDeleteActivity.this, "กรุณาป้อนข้อมูลให้ครบ", Toast.LENGTH_SHORT).show();
                }
                else
                    {
                    dbHelper.updateData(userModel.getId(), etdate.getText().toString(), etdrug.getText().toString(), etsympton.getText().toString(), ettreament.getText().toString());
                    Toast.makeText(UpdateDeleteActivity.this, "อัพเดทข้อมูลเรียบร้อย", Toast.LENGTH_SHORT).show();

                    //when after delete go to show second page
                    Intent intentUp = new Intent(UpdateDeleteActivity.this, second.class);
                    intentUp.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intentUp);
                }
            }
        });
                ////////Button delete //////////////////
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteData(userModel.getId(),getApplicationContext());
                    ////////when after delete go to second page///////
                Intent intentDel = new Intent(UpdateDeleteActivity.this,second.class);
                intentDel.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentDel);
            }
        });
    }
}
