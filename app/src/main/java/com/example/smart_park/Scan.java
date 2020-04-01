package com.example.smart_park;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Scan extends AppCompatActivity {
    Button mScan;
    public String contents1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        mScan=findViewById(R.id.button);




    }
    public void scancode(View view){
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        //intent.setPackage("com.google.zxing.client.android");
        intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
        startActivityForResult(intent, 0);


    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                contents1 = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                Toast.makeText(this, contents1,Toast.LENGTH_LONG).show();
                if(contents1.equals("entry")){
                    Toast.makeText(this, "entry successful", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(this,Starttimer.class);
                startActivity(myIntent);}
                else {
                    Toast.makeText(this, "Scan the correct QR code ", Toast.LENGTH_SHORT).show();
                }
            } else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
                Toast.makeText(this, "cancelled", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
