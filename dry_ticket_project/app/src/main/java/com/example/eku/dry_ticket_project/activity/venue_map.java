package com.example.eku.dry_ticket_project.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

import com.example.eku.dry_ticket_project.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class venue_map extends ActionBarActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_map);
        setUpMapIfNeeded();
        getSupportActionBar();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(-33.868353, 151.196271)).title("Sydney Lyric Theater"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-33.873178, 151.206583)).title("Sydney Town Hall NSW"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-36.757164, 144.276340)).title("The Capitol"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-34.551849, 146.405458)).title("Roxy Theater"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-33.833029, 151.046938)).title("C3 Conference venue"));
        CameraUpdate center =
                CameraUpdateFactory.newLatLng(new LatLng(-33.378337, 148.255190));
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
        mMap.moveCamera(center);
       // mMap.animateCamera(zoom);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m = getMenuInflater();
        m.inflate(R.menu.menu_file, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sign_in) {
            Intent intent = new Intent(venue_map.this, sign_in.class);
            startActivity(intent);
        } else if (id == R.id.add_menu) {
            Intent intent = new Intent(venue_map.this, sign_up.class);
            startActivity(intent);

            return true;
        } else if (id == R.id.now_on_sale) {
            Intent intent = new Intent(venue_map.this, NowOnSale.class);
            startActivity(intent);

        } else if (id == R.id.upcoming) {
            Intent intent = new Intent(venue_map.this, UpcomingEvents.class);
            intent.putExtra("url_string", "http://bishasha.com/json/upcoming_events.php");
            startActivity(intent);

        } else if (id == R.id.past) {
            Intent intent = new Intent(venue_map.this, PastEvents.class);
            intent.putExtra("url_string", "http://bishasha.com/json/past_events.php");
            startActivity(intent);



        } else if (id == R.id.artists) {
            Intent intent = new Intent(venue_map.this, Artist_information.class);
            startActivity(intent);

        } else if (id == R.id.venue) {
            Intent intent = new Intent(venue_map.this, Venue.class);
            startActivity(intent);

        } else if (id == R.id.contact_us) {
            Intent intent = new Intent(venue_map.this, ContactUs.class);
            startActivity(intent);


        }
        return super.onOptionsItemSelected(item);
    }
}



/*
    @Override
    public boolean onTouchEvent(MotionEvent event, MapView mapView) {
        if (event.getAction() == 1) {

            GeoPoint geopoint;
            geopoint = mapView.getProjection().fromPixels(
                    (int) event.getX(),
                    (int) event.getY());
            // latitude
            double lat = geopoint.getLatitudeE6() / 1E6;
            // longitude
            double lon = geopoint.getLongitudeE6() / 1E6;
            Context context=null;
            Toast.makeText(context, "Lat: " + lat + ", Lon: " + lon, Toast.LENGTH_SHORT).show();
        }
        return false;

    }

    private class GeoPoint {
        private double latitudeE6;
        private double longitudeE6;

        public double getLatitudeE6() {
            return latitudeE6;
        }

        public double getLongitudeE6() {
            return longitudeE6;
        }
    }
}
*/
