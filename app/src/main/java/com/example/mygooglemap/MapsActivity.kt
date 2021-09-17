package com.example.mygooglemap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.mygooglemap.databinding.ActivityMaps2Binding
import android.R
import android.view.View
import android.content.Intent

import androidx.core.content.ContextCompat.startActivity

import androidx.annotation.NonNull
import androidx.core.content.ContextCompat


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private var adView: AdView? = null
    var adRequest: AdRequest? = null
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMaps2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adView = findViewById<View>(R.id.ad_view) as AdView
        adRequest = Builder().build()
        adView.loadAd(adRequest)
        binding = ActivityMaps2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
}
@Override
public void onPause() {
    if (adView != null) {
        adView.pause();
    }
    super.onPause();
}

@Override
public void onResume() {
    super.onResume();
    if (adView != null) {
        adView.resume();
    }
}

@Override
public void onDestroy() {
    if (adView != null) {
        adView.destroy();
    }
    super.onDestroy();
}
}
}
@Override
public void onPause() {
    if (adView != null) {
        adView.pause();
    }
    super.onPause();
}

@Override
public void onResume() {
    super.onResume();
    if (adView != null) {
        adView.resume();
    }
}

@Override
public void onDestroy() {
    if (adView != null) {
        adView.destroy();
    }
    super.onDestroy();
}
}
fun onCreateOptionsMenu(menu: Menu?): Boolean {
    getMenuInflater().inflate(R.menu.main_menu, menu)

    // first parameter is the file for icon and second one is menu
    return super.onCreateOptionsMenu(menu)
}

fun onOptionsItemSelected(item: MenuItem): Boolean {
    // We are using switch case because multiple icons can be kept
    when (item.getItemId()) {
        R.id.shareButton -> {
            val sharingIntent = Intent(Intent.ACTION_SEND)

            // type of the content to be shared
            sharingIntent.type = "text/plain"

            // Body of the content
            val shareBody = "Your Body Here"

            // subject of the content. you can share anything
            val shareSubject = "Your Subject Here"

            // passing body of the content
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)

            // passing subject of the content
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject)
            startActivity(Intent.createChooser(sharingIntent, "Share using"))
        }
    }
    return super.onOptionsItemSelected(item)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}