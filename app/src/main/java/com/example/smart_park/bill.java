package com.example.smart_park;
import com.example.smart_park.Starttimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class bill extends AppCompatActivity {
    double total_hour;
    double total_minutes;
    double total_price;
    double minimumprice;
    double total_hour_price;
    TextView t4,t2,t3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        t4=findViewById(R.id.hours1);
        t2=findViewById(R.id.minimum);
        t3=findViewById(R.id.total);
        minimumprice=20.0;
       // Starttimer t1=new Starttimer();
        //total_hour=t1.minutes;
        Bundle bundle = getIntent().getExtras();
        String stuff = bundle.getString("stuff");
        //Toast.makeText(this, "stuff"+stuff, Toast.LENGTH_SHORT).show();
        total_minutes=Float.valueOf(stuff);
        total_hour=total_minutes/60;
        total_hour_price=total_hour*15.0;


       // Toast.makeText(this,Double.toString(total_hour) , Toast.LENGTH_SHORT).show();
        total_price=minimumprice+total_hour_price;
       // total_price=9000;
        t4.setText(Double.toString(total_hour_price));
        t2.setText(Double.toString(minimumprice));
        t3.setText(Double.toString(total_price));

        //t.setTe






    }
    public void pay(View view){
        Intent myIntent = new Intent(getApplicationContext(),upi.class);
        //startActivity(myIntent);

        Bundle bundle = new Bundle();
        bundle.putString("stuffs", Double.toString(total_price));
        myIntent.putExtras(bundle);
        startActivity(myIntent);

    }


}
