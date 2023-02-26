package com.example.activitatgooglemaps;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

public class Preferencies extends PreferenceActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencies);
    }
}
