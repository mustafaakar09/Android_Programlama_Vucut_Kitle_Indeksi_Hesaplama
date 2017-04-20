package com.example.asus_pc.deneme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    EditText adi, boy, kilo;
    TextView goster,deger;
    RadioButton bay, bayan;
    Button hesapla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        adi = (EditText) findViewById(R.id.ad);
        boy = (EditText) findViewById(R.id.boy);
        kilo = (EditText) findViewById(R.id.kilo);
        goster = (TextView) findViewById(R.id.goster);
        hesapla = (Button) findViewById(R.id.hesapla);

        deger=(TextView)findViewById(R.id.deger);
        bay = (RadioButton) findViewById(R.id.bay);
        bayan = (RadioButton) findViewById(R.id.bayan);

        hesapla.setOnClickListener(new View.OnClickListener() {
            String sec;
            int t = 0, z = 1;
           float a = 0, b = 0;

            @Override

            public void onClick(View v) {
                a = Float.parseFloat(boy.getText().toString());
                b = Float.parseFloat(kilo.getText().toString());
                String isim = adi.getText().toString();
                if (bay.isChecked()) {
                    sec = "Bey";
                }
                if (bayan.isChecked()) {
                    sec = "Hanım";
                }

                if (adi.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Lütfen Alanları Dogru Doldurunuz", Toast.LENGTH_LONG).show();
                }


                float bol = (a / 100);
                float sonuc = (b / (bol * bol));
                if (t == 0) {
                    goster.setText(isim + " " + sec + " V.K.İ=");
                    deger.setText(""+sonuc);
                }


            }
        });


    }
    public void Tikla(View v) {
        if (v.getId() == R.id.Detay) {
            float gidenveri=Float.parseFloat(deger.getText().toString());
            Intent intent = new Intent(getApplicationContext(),Ekran2.class);
            intent.putExtra("anahtar",gidenveri);
            startActivity(intent);

        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {




        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        if(id==R.id.yenilebtn){
            Toast.makeText(this,"yenileme yapılıyor",Toast.LENGTH_LONG).show();

        }
        if(item.getItemId()==android.R.id.home){
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            NavUtils.navigateUpTo(this,intent);
            return true;

        }

        return super.onOptionsItemSelected(item);
    }


}
