package com.rku_18fotca11039.tutorial06;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText etxtemail;
    EditText etxtpassword;
    Button btnlogin;
//    final Vibrator vibe = (Vibrator) login.this.getSystemService(Context.VIBRATOR_SERVICE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etxtemail = findViewById(R.id.etxtemail);
        etxtpassword = findViewById(R.id.etxtpassword);
        btnlogin = findViewById(R.id.btnlogin);


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void btnloginClick(View view) {




        String valusername = etxtemail.getText().toString();
        String valpassword = etxtpassword.getText().toString();

        if(valusername.equals("")){
            Toast.makeText(this, "Username can not be empty.", Toast.LENGTH_SHORT).show();
            return ;
        }
        if(valpassword.equals("")){
            Toast.makeText(this, "Password can not be empty.", Toast.LENGTH_SHORT).show();
            return ;
        }
        if (valpassword.length()<6){
            Toast.makeText(this, "Password must be of minimum 6 character.", Toast.LENGTH_SHORT).show();
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(valusername).matches()){
            Toast.makeText(this, "Username must be proper email address.", Toast.LENGTH_SHORT).show();
        }

//        vibe.vibrate(80);//80 represents the milliseconds (the duration of the vibration)

        if(valusername.equals("admin@gmail.com") && valpassword.equals("123456")){

            Intent intent = new Intent(login.this,welcome.class);
            intent.putExtra("Welcome",etxtemail.getText().toString());
            startActivity(intent);
            finish();

            SharedPreferences preferences = getSharedPreferences("clg",MODE_PRIVATE);

            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
             editor.putString("username",valusername);

            editor.commit();




            Toast.makeText(this, "Loggin Successful", Toast.LENGTH_SHORT).show();


        }else{
            Toast.makeText(this, "Loggin failed", Toast.LENGTH_SHORT).show();
        }

    }

    public void registration(View view) {
        Intent intent = new Intent(login.this,registration.class);
        startActivity(intent);
        finish();
    }
}