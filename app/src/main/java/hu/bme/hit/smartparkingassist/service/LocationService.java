package hu.bme.hit.smartparkingassist.service;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;

import hu.bme.hit.smartparkingassist.location.LDLocationManager;

public class LocationService extends Service implements LocationListener {

    public static final String BR_NEW_LOCATION = "BR_NEW_LOCATION";
    public static final String KEY_LOCATION = "KEY_LOCATION";

    private LDLocationManager ldLocationManager = null;
    private boolean locationMonitorRunning = false;

    private final IBinder locationBinder = new LocationBinder();

    public class LocationBinder extends Binder {
        public LocationService getService() {
            return LocationService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        if (!locationMonitorRunning) {
            locationMonitorRunning = true;
            ldLocationManager = new LDLocationManager(getApplicationContext(), this);
            ldLocationManager.startLocationMonitoring();
        }

        return locationBinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (ldLocationManager != null) {
            ldLocationManager.stopLocationMonitoring();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        Intent intent = new Intent(BR_NEW_LOCATION);
        intent.putExtra(KEY_LOCATION, location);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
