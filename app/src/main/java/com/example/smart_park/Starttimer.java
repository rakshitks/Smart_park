package com.example.smart_park;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Starttimer extends AppCompatActivity {
    TextView timerTextView;
   public long startTime = 0;
    public double hour;
    public int minutes;
    String contents="";
    double total_hour_price;
    //int minimumprice;
    //runs without a timer by reposting this handler at the end of the runnable
    Handler timerHandler = new Handler();
    final Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            minutes = seconds / 60;
            seconds = seconds % 60;

            timerTextView.setText(String.format("%d:%02d", minutes, seconds));

            timerHandler.postDelayed(this, 500);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starttimer);
        timerTextView = (TextView) findViewById(R.id.timerTextView);
        startTime = System.currentTimeMillis();
        timerHandler.postDelayed(timerRunnable, 0);

        Button b = (Button) findViewById(R.id.button1234);
        b.setText("stop");
        //if(contents1)
        //starttimer();
        //onClick();
       /* b.setOnClickListener(new View.OnClickListener() {

          @Override
           public void onClick(View v) {
                Button b = (Button) v;
               if (b.getText().equals("stop")) {
                    timerHandler.removeCallbacks(timerRunnable);
                    b.setText("start");
                } else {
                    startTime = System.currentTimeMillis();
                    timerHandler.postDelayed(timerRunnable, 0);
                    b.setText("stop");
                }
            }
        });*/
    }
    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        Toast.makeText(getApplicationContext(),"There is no back action",Toast.LENGTH_LONG).show();
        //return;
    }
    /*public void starttimer(){
        startTime = System.currentTimeMillis();
        timerHandler.postDelayed(timerRunnable, 0);
        Toast.makeText(getApplicationContext(), "thank you", Toast.LENGTH_SHORT).show();

    }*/
    public void stoptimer(View view){
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        //intent.setPackage("com.google.zxing.client.android");
        intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
        startActivityForResult(intent, 0);
        //if (contents=="exit"){
            //timerHandler.removeCallbacks(timerRunnable);

           // calculateprice();
            //finish();
            //Intent myIntent = new Intent(this,bill.class);
            //startActivity(myIntent);

       // }
        //else{
          //  Toast.makeText(this, "Scan the correct exit code properly", Toast.LENGTH_SHORT).show();
       // }


        //timerHandler.removeCallbacks(timerRunnable);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                 contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                Toast.makeText(this, contents,Toast.LENGTH_LONG).show();
               // if(contents)
                if (contents.equals("exit")){
                    //timerHandler.removeCallbacks(timerRunnable);
                    //Toast.makeText(getApplicationContext(), "equals exit is true", Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show();



                    Intent myIntent = new Intent(getApplicationContext(),bill.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("stuff", Float.toString(minutes));
                    myIntent.putExtras(bundle);
                    startActivity(myIntent);


                   // finish();
                    //Intent myIntent = new Intent(this,bill.class);
                    //startActivity(myIntent);

                }
                else{
                    Toast.makeText(this, "Wrong qr code scanned", Toast.LENGTH_SHORT).show();
                }


                //Intent myIntent = new Intent(this,Starttimer.class);
               // startActivity(myIntent);
                // Handle successful scan
            } else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
                Toast.makeText(this, "cancelled", Toast.LENGTH_SHORT).show();

            }
        }
    }
   // public  double calculateprice(){

      //  hour=minutes/60;
       // final double minutes=this.minutes;
       // Toast.makeText(getApplicationContext(), "minutes"+minutes, Toast.LENGTH_SHORT).show();
       // total_hour_price=hour*15.0;
       // Toast.makeText(this, Double.toString(total_hour_price), Toast.LENGTH_SHORT).show();


        //return minutes;



    }
//}
