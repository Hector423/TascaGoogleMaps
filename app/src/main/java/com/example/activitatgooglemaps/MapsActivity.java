package com.example.activitatgooglemaps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.activitatgooglemaps.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        LatLng bangor = new LatLng(44.79815412287835, -68.7732079498604);
        LatLng santiago = new LatLng(-33.456153371573194, -70.64956511892082);
        LatLng bogota = new LatLng(4.740328531486702, -74.04890033103689);
        LatLng saoPaulo = new LatLng(-23.527640215511617, -46.66786248844115);
        LatLng rioDeJaneiro = new LatLng(-22.91320630400053, -43.17140788845218);
        LatLng fortworth = new LatLng(32.74113809653637, -97.36895660196694);
        mMap.addMarker(new MarkerOptions().position(bangor).title("Bangor, US"));
        mMap.addMarker(new MarkerOptions().position(saoPaulo).title("São Paulo, Brazil"));
        mMap.addMarker(new MarkerOptions().position(bogota).title("Bogota, Colombia"));
        mMap.addMarker(new MarkerOptions().position(santiago).title("Santiago, Chile"));
        mMap.addMarker(new MarkerOptions().position(rioDeJaneiro).title("Rio de Janeiro, Brazil"));
        mMap.addMarker(new MarkerOptions().position(fortworth).title("Fort Worth, TX, US"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bangor));

    }
}