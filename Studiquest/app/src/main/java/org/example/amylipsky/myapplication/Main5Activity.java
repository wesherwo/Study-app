package org.example.amylipsky.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

//Google Maps Class
public class Main5Activity extends AppCompatActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    private String val;
    private FirebaseDatabase database;
    private DatabaseReference locationmarkerRef;
    private DatabaseReference locationmarkerChildRef;

    private FirebaseDatabase Mydatabase;
    private DatabaseReference groupRef;
    private DatabaseReference groupKey;
    private String getLocation;
    private String getCourse;
    private String getStart;
    private String getEnd;
    private String getnumppl;
    private String groupID;

    private double longitude = 0;
    private double lat = 0;
    ArrayList<String> locationkey = new ArrayList<String>();
    ArrayList<String> locationlist = new ArrayList<String>();

    private static final String TAG = "DataBase";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

        System.out.println("BEFORE THE FUNCTION");
        database = FirebaseDatabase.getInstance();
        locationmarkerRef = database.getReference("location marker");

        database = FirebaseDatabase.getInstance();
        groupRef = database.getReference("groups");
        groupKey = groupRef.push();
        groupID = groupKey.getKey();



        //database.






        /*groupRef.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               /* getLocation = dataSnapshot.child(groupID).child("locations");
               getCourse = dataSnapshot.child("course").getValue().toString();
                getStart = dataSnapshot.child("starttime").getValue().toString();
                getEnd = dataSnapshot.child("endtime").getValue().toString();
                getnumppl = dataSnapshot.child("numppl").getValue().toString();*/
                //System.out.println("LOCATION****"+getLocation);
                /*System.out.println("COURSE" + getCourse);
                System.out.println("START" + getStart);
                System.out.println("END" + getEnd);
                System.out.println("NUM" + getnumppl);*/
    private LatLngBounds UniversityAtBuffalo = new LatLngBounds(new LatLng(42.99262, -78.799561),
            new LatLng(43.012405, -78.770156));


    /*private LatLngBounds UniversityAtBuffalo = new LatLngBounds(new LatLng(42.975091,-78.806297),
            new LatLng(43.020720,-78.766133));*/


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //mMap.setLatLngBoundsForCameraTarget(UniversityAtBuffalo);

        //mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(UniversityAtBuffalo, 17));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UniversityAtBuffalo.getCenter(), 17));

        LatLng test = new LatLng(43.001268, -78.789202);

        Marker tester = mMap.addMarker(new MarkerOptions().position(test).title(" ").snippet("Capen CSE 3:00pm 6:00pm 5"));

        // Add a marker in Sydney and move the camera
        LatLng buffalo = new LatLng(43, -78.7865);
        //mMap.addMarker(new MarkerOptions().position(buffalo).title("Marker in Buffalo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(buffalo));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(buffalo, 14));


    }


}