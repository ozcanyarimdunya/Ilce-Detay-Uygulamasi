package com.ozcaan11.l50.ilcedetayuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ListView listView;
    ArrayAdapter<String> iller;
    ArrayAdapter<String> ilceler;
    Ilceler ilce;
    private String[] HangiIl = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Islemler();

    }

    public void Islemler() {
        spinner = (Spinner) findViewById(R.id.spinner);
        listView = (ListView) findViewById(R.id.listView);
        ilce = new Ilceler();
        final Iller il = new Iller();
        ArrayList<String> arrayList = il.yukle();
        iller = new ArrayAdapter<>(getApplicationContext(), R.layout.my_spin, arrayList);
        spinner.setAdapter(iller);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch ((int) id) {
                    case 0:
                        ilceler = new ArrayAdapter<String>(getApplicationContext(), R.layout.my_list, ilce.Bos);
                        HangiIl = ilce.Bos;
                        listView.setAdapter(ilceler);
                        break;
                    case 1:
                        ilceler = new ArrayAdapter<String>(getApplicationContext(), R.layout.my_list, ilce.Adana);
                        HangiIl = ilce.Adana;
                        listView.setAdapter(ilceler);
                        break;
                    case 2:
                        ilceler = new ArrayAdapter<String>(getApplicationContext(), R.layout.my_list, ilce.Adiyaman);
                        HangiIl = ilce.Adiyaman;
                        listView.setAdapter(ilceler);
                        break;
                    case 3:
                        ilceler = new ArrayAdapter<String>(getApplicationContext(), R.layout.my_list, ilce.Afyon);
                        HangiIl = ilce.Afyon;
                        listView.setAdapter(ilceler);
                        break;
                    case 4:
                        ilceler = new ArrayAdapter<String>(getApplicationContext(), R.layout.my_list, ilce.Agri);
                        HangiIl = ilce.Agri;
                        listView.setAdapter(ilceler);
                        break;
                    case 5:
                        ilceler = new ArrayAdapter<String>(getApplicationContext(), R.layout.my_list, ilce.Aksaray);
                        HangiIl = ilce.Aksaray;
                        listView.setAdapter(ilceler);
                        break;
                    case 6:
                        ilceler = new ArrayAdapter<String>(getApplicationContext(), R.layout.my_list, ilce.Amasya);
                        HangiIl = ilce.Amasya;
                        listView.setAdapter(ilceler);
                        break;
                    case 7:
                        ilceler = new ArrayAdapter<String>(getApplicationContext(), R.layout.my_list, ilce.Ankara);
                        HangiIl = ilce.Ankara;
                        listView.setAdapter(ilceler);
                        break;
                    case 8:
                        ilceler = new ArrayAdapter<String>(getApplicationContext(), R.layout.my_list, ilce.Antalya);
                        HangiIl = ilce.Antalya;
                        listView.setAdapter(ilceler);
                        break;
                    case 9:
                        ilceler = new ArrayAdapter<String>(getApplicationContext(), R.layout.my_list, ilce.Ardahan);
                        HangiIl = ilce.Ardahan;
                        listView.setAdapter(ilceler);
                        break;
                    case 10:
                        ilceler = new ArrayAdapter<String>(getApplicationContext(), R.layout.my_list, ilce.Artvin);
                        HangiIl = ilce.Artvin;
                        listView.setAdapter(ilceler);
                        break;
                    case 11:
                        ilceler = new ArrayAdapter<String>(getApplicationContext(), R.layout.my_list, ilce.Aydin);
                        HangiIl = ilce.Aydin;
                        listView.setAdapter(ilceler);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                intent.putExtra("IlceDetay", HangiIl[position]);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
