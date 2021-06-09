package com.example.qrscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static Button scanbtn,openlink;
    public static TextView scantext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      scanbtn= (Button)findViewById(R.id.button);
      scantext=(TextView)findViewById(R.id.textView);
      openlink=(Button)findViewById(R.id.button2);
      openlink.setEnabled(false);

      scanbtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              startActivity(new Intent(getApplicationContext(),scannerView.class));
          }
      });

      openlink.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              gotoUrl(scantext.getText().toString());
          }
      });


    }

    private void gotoUrl(String s) {
        Uri ur = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,ur));

    }
}