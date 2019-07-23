package com.custommaptest;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.custommaptest.CustomInfoWindowGoogleMap;
import com.custommaptest.InfoWindowData;
import com.custommaptest.R;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapInfoWindowActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {


        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.clear();


        LatLng media365 = new LatLng(23.768236, 90.3587349);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(media365));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(12));


        Marker m1=  mMap.addMarker(new MarkerOptions()
                .position(new LatLng(23.7517761, 90.3740075))
                .title("")
                .snippet("")
                .rotation((float) 0));

        Marker m= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(23.7681185, 90.3587611))
                .title("")
                .snippet("")
                .rotation((float) 0));



        InfoWindowData info = new InfoWindowData();
        info.setImage("img");
        info.setHotel("Hotel : excellent hotels available");
        info.setFood("Food : all types of restaurants available");
        info.setTransport("Reach the site by bus, car and train.");
        CustomInfoWindowGoogleMap customInfoWindow = new CustomInfoWindowGoogleMap(this);
        mMap.setInfoWindowAdapter(customInfoWindow);
        m.setTag(info);
        m1.setTag(info);
//        m2.setTag(info);





    }


}