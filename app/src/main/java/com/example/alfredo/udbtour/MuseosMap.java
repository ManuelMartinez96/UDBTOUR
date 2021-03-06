package com.example.alfredo.udbtour;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MuseosMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museos_map);
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




        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);


        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);

        // Museo de Arte de El Salvador
        LatLng marte = new LatLng(13.692624, -89.241932);
        mMap.addMarker(new MarkerOptions().position(marte).title("Museo de Arte de El Salvador").icon(BitmapDescriptorFactory.fromResource(R.drawable.museum)));

        //Museo Nacional Dr. David J. Guzmán
        LatLng museodavid = new LatLng(13.687182, -89.238772);
        mMap.addMarker(new MarkerOptions().position(museodavid).title("Museo Nacional Dr. David J. Guzmán").icon(BitmapDescriptorFactory.fromResource(R.drawable.museum)));

        //Museo del Ferrocarril y Parque Temático
        LatLng ferrocarril = new LatLng(13.700938, -89.177667);
        mMap.addMarker(new MarkerOptions().position(ferrocarril).title("Museo del Ferrocarril y Parque Temático").icon(BitmapDescriptorFactory.fromResource(R.drawable.museum)));

        //Museo de Aviación
        LatLng aviacion = new LatLng(13.695890, -89.115100);
        mMap.addMarker(new MarkerOptions().position(aviacion).title("Museo de Aviación").icon(BitmapDescriptorFactory.fromResource(R.drawable.museum)));

        //Museo de la Palabra y la Imagen
        LatLng museopalabra = new LatLng(13.709297, -89.205009);
        mMap.addMarker(new MarkerOptions().position(museopalabra).title("Museo de la Palabra y la Imagen").icon(BitmapDescriptorFactory.fromResource(R.drawable.museum)));

        //Tin Marín, Museo de los Niños
        LatLng tinmarin = new LatLng(13.525478, -89.804414);
        mMap.addMarker(new MarkerOptions().position(tinmarin).title("Tin Marín, Museo de los Niños").icon(BitmapDescriptorFactory.fromResource(R.drawable.museum)));



        float zoomlevel = 16;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marte, zoomlevel));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);


    }


    public void tipoNormal(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    public void tipoSatelite(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }

    public void tipoHibrido(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
}
