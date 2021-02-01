package com.rku_18fotca11039.tutorial06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.Preference;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class welcome extends AppCompatActivity {
    TextView textView;
    SharedPreferences preferences;
//    final Vibrator vibe = (Vibrator) welcome.this.getSystemService(Context.VIBRATOR_SERVICE);

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Bundle bundle  = getIntent().getExtras();
//        String  etxtemail  = bundle.getString("Welcome");
        textView = findViewById(R.id.textView);
//        textView.setText("Welcome, "+ etxtemail);

        preferences = getSharedPreferences("clg",MODE_PRIVATE);
        String userpreferences = preferences.getString("username","");
        if (userpreferences.equals(""))
        {
            Intent intent = new Intent(welcome.this,login.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        vibe.vibrate(80);//80 represents the milliseconds (the duration of the vibration)

        int id  = item.getItemId();

        switch (id){
            case R.id.logout:
                Toast.makeText(this, "Loggedout", Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(welcome.this,login.class);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }



}