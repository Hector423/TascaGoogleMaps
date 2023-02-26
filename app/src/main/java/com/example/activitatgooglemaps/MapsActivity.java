package com.example.activitatgooglemaps;

import androidx.fragment.app.FragmentActivity;

import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.activitatgooglemaps.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    int idEfecte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        mp = MediaPlayer.create(this, R.raw.musica_mapa);
//        mp.start();
        MusicHolder.UpdateContext(MapsActivity.this);
        if(!MusicHolder.isInitialized()) MusicHolder.Start();

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
        LatLng bethel = new LatLng(41.69720618735568, -74.87763868769002);
        LatLng bogota = new LatLng(4.740328531486702, -74.04890033103689);
        LatLng saoPaulo = new LatLng(-23.527640215511617, -46.66786248844115);
        LatLng rioDeJaneiro = new LatLng(-22.91320630400053, -43.17140788845218);
        LatLng fortworth = new LatLng(32.74113809653637, -97.36895660196694);
        LatLng durant = new LatLng(33.95185097510312, -96.41259434469025);
        LatLng southaven = new LatLng(34.95142640558342, -89.93410762747492);
        LatLng charlotte = new LatLng(35.32725546615668, -80.71226838698718);
        mMap.addMarker(new MarkerOptions().position(bangor).title("Bangor, EEUU").icon(BitmapDescriptorFactory.fromResource(R.drawable.icono)));
        mMap.addMarker(new MarkerOptions().position(durant).title("Durant, OK, EEUU").icon(BitmapDescriptorFactory.fromResource(R.drawable.icono)));
        mMap.addMarker(new MarkerOptions().position(charlotte).title("Charlotte, NC, EEUU").icon(BitmapDescriptorFactory.fromResource(R.drawable.icono)));
        mMap.addMarker(new MarkerOptions().position(southaven).title("Southaven, MS, EEUU").icon(BitmapDescriptorFactory.fromResource(R.drawable.icono)));
        mMap.addMarker(new MarkerOptions().position(saoPaulo).title("São Paulo, Brazil").icon(BitmapDescriptorFactory.fromResource(R.drawable.icono)));
        mMap.addMarker(new MarkerOptions().position(bogota).title("Bogota, Colombia").icon(BitmapDescriptorFactory.fromResource(R.drawable.icono)));
        mMap.addMarker(new MarkerOptions().position(bethel).title("Bethel, NY, EEUU").icon(BitmapDescriptorFactory.fromResource(R.drawable.icono)));
        mMap.addMarker(new MarkerOptions().position(rioDeJaneiro).title("Rio de Janeiro, Brazil").icon(BitmapDescriptorFactory.fromResource(R.drawable.icono)));
        mMap.addMarker(new MarkerOptions().position(fortworth).title("Fort Worth, TX, EEUU").icon(BitmapDescriptorFactory.fromResource(R.drawable.icono)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bangor));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(15));

    }
}