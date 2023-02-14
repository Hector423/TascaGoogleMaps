package com.example.activitatgooglemaps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class LlistatGira extends AppCompatActivity {

    private Spinner spinner, spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llistat_gira);

    spinner = findViewById(R.id.spinner);
    spinner2 = findViewById(R.id.spinner2);


        String dropdownOptions[] = new String[3];

        dropdownOptions[0] = "asd";
        dropdownOptions[1] = "asd";
        dropdownOptions[2] = "asd";





        ArrayAdapter<String> adapterView1 = new ArrayAdapter<String>
                (
                        this,
                        android.R.layout.simple_spinner_item, dropdownOptions
                );
        adapterView1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterView1);



    }




}