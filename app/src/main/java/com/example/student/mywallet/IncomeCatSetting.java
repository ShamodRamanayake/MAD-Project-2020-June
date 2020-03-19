package com.example.student.mywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Database.WalletDBhelper;

public class IncomeCatSetting extends AppCompatActivity {
    WalletDBhelper db;
    EditText ishuaddincome;
    private String name2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_cat_setting);
        ishuaddincome = findViewById(R.id.ishuaddincome);
        db = new WalletDBhelper(this);
    }

    public void addincomeCat(View view){
        if(TextUtils.isEmpty(ishuaddincome.getText()) ){
            ishuaddincome.setError("Enter an Value!");
            ishuaddincome.requestFocus();

        }else {
            name2 = ishuaddincome.getText().toString();
            boolean result = db.addincomeCatishu(name2);
            ishuaddincome.getText().clear();

            if (result == true) {
                Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, DasboardIncomeCate.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Faild!", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void deleteUser(View view){
        name2 = ishuaddincome.getText().toString();
        boolean result = db.deleteuser( name2 );

        if(result == true){
            Toast.makeText(getApplicationContext(),"Success!",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, DashboardExpensesCate.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Failed!",Toast.LENGTH_LONG).show();
        }


    }

    public void update( View view){
        name2 = ishuaddincome.getText().toString();
        boolean result = db.userUpdate( name2 );
        if(result == true){
            Toast.makeText(getApplicationContext(),"Success!",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, DashboardExpensesCate.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Failed!",Toast.LENGTH_LONG).show();
        }

    }




    public void goBack(View view){
        Intent intent =new Intent(IncomeCatSetting.this,DasboardIncomeCate.class);
        startActivity(intent);
    }
}
