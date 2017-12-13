package psi.com.psi.map;

import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import psi.com.psi.R;
import psi.com.psi.data.HttpClient;
import psi.com.psi.data.psi.Psi;
import psi.com.psi.data.psi.RegionMetadata;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback ,
        PsiView, GoogleMap.InfoWindowAdapter {

    private GoogleMap mMap;
    private View mapView;
    private boolean showPsi;
    private Psi result;

    private static final String NATIONAL = "national";
    private static final String NORTH = "north";
    private static final String EAST = "east";
    private static final String SOUTH = "south";
    private static final String WEST = "west";
    private static final String CENTRAL = "central";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mapView = findViewById(R.id.map);

        PsiPresenter presenter = new PsiPresenter(new PsiModel(HttpClient.getInstance()), this);
        presenter.loadPsi();
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
        mMap.setInfoWindowAdapter(this);

        if(showPsi){
            displayPsiResult();
        }
    }

    @Override
    public void showPsi(Psi result) {
        this.result = result;

        if(mMap != null){
            displayPsiResult();
            return;
        }

        showPsi = true;
    }

    private void displayPsiResult() {

        for(RegionMetadata meta: result.regionMetadata){
            if(meta.name.equals(NATIONAL)){
                continue;
            }

            LatLng latLng = new LatLng(meta.labelLocation.latitude,meta.labelLocation.longitude);
            mMap.addMarker(new MarkerOptions().position(latLng).title(meta.name));

            if(meta.name.equals(CENTRAL)){
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
            }
        }
    }

    @Override
    public void showError(String message) {
        Snackbar.make(mapView, message,Snackbar.LENGTH_INDEFINITE).show();
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = getLayoutInflater().inflate(R.layout.psi_reading, null);

        if(result.items.size() == 1){

            switch (marker.getTitle()){
                case NORTH:
                    fillInfoWindow(view,
                            result.items.get(0).readings.o3SubIndex.north,
                            result.items.get(0).readings.pm10TwentyFourHourly.north,
                            result.items.get(0).readings.pm10SubIndex.north,
                            result.items.get(0).readings.coSubIndex.north,
                            result.items.get(0).readings.pm25TwentyFourHourly.north,
                            result.items.get(0).readings.so2SubIndex.north,
                            result.items.get(0).readings.coEightHourMax.north,
                            result.items.get(0).readings.no2OneHourMax.north,
                            result.items.get(0).readings.so2TwentyFourHourly.north,
                            result.items.get(0).readings.pm25SubIndex.north,
                            result.items.get(0).readings.psiTwentyFourHourly.north,
                            result.items.get(0).readings.o3EightHourMax.north
                            );
                    break;
                case EAST:
                    fillInfoWindow(view,
                            result.items.get(0).readings.o3SubIndex.east,
                            result.items.get(0).readings.pm10TwentyFourHourly.east,
                            result.items.get(0).readings.pm10SubIndex.east,
                            result.items.get(0).readings.coSubIndex.east,
                            result.items.get(0).readings.pm25TwentyFourHourly.east,
                            result.items.get(0).readings.so2SubIndex.east,
                            result.items.get(0).readings.coEightHourMax.east,
                            result.items.get(0).readings.no2OneHourMax.east,
                            result.items.get(0).readings.so2TwentyFourHourly.east,
                            result.items.get(0).readings.pm25SubIndex.east,
                            result.items.get(0).readings.psiTwentyFourHourly.east,
                            result.items.get(0).readings.o3EightHourMax.east
                    );
                    break;
                case SOUTH:
                    fillInfoWindow(view,
                            result.items.get(0).readings.o3SubIndex.south,
                            result.items.get(0).readings.pm10TwentyFourHourly.south,
                            result.items.get(0).readings.pm10SubIndex.south,
                            result.items.get(0).readings.coSubIndex.south,
                            result.items.get(0).readings.pm25TwentyFourHourly.south,
                            result.items.get(0).readings.so2SubIndex.south,
                            result.items.get(0).readings.coEightHourMax.south,
                            result.items.get(0).readings.no2OneHourMax.south,
                            result.items.get(0).readings.so2TwentyFourHourly.south,
                            result.items.get(0).readings.pm25SubIndex.south,
                            result.items.get(0).readings.psiTwentyFourHourly.south,
                            result.items.get(0).readings.o3EightHourMax.south
                    );
                    break;
                case WEST:
                    fillInfoWindow(view,
                            result.items.get(0).readings.o3SubIndex.west,
                            result.items.get(0).readings.pm10TwentyFourHourly.west,
                            result.items.get(0).readings.pm10SubIndex.west,
                            result.items.get(0).readings.coSubIndex.west,
                            result.items.get(0).readings.pm25TwentyFourHourly.west,
                            result.items.get(0).readings.so2SubIndex.west,
                            result.items.get(0).readings.coEightHourMax.west,
                            result.items.get(0).readings.no2OneHourMax.west,
                            result.items.get(0).readings.so2TwentyFourHourly.west,
                            result.items.get(0).readings.pm25SubIndex.west,
                            result.items.get(0).readings.psiTwentyFourHourly.west,
                            result.items.get(0).readings.o3EightHourMax.west
                    );

                    break;
                case CENTRAL:
                    fillInfoWindow(view,
                            result.items.get(0).readings.o3SubIndex.central,
                            result.items.get(0).readings.pm10TwentyFourHourly.central,
                            result.items.get(0).readings.pm10SubIndex.central,
                            result.items.get(0).readings.coSubIndex.central,
                            result.items.get(0).readings.pm25TwentyFourHourly.central,
                            result.items.get(0).readings.so2SubIndex.central,
                            result.items.get(0).readings.coEightHourMax.central,
                            result.items.get(0).readings.no2OneHourMax.central,
                            result.items.get(0).readings.so2TwentyFourHourly.central,
                            result.items.get(0).readings.pm25SubIndex.central,
                            result.items.get(0).readings.psiTwentyFourHourly.central,
                            result.items.get(0).readings.o3EightHourMax.central
                    );

                    break;
            }

        }

        return view;
    }

    public void fillInfoWindow(View view,
                                int o3SubIndex,
                                int pm10TwentyFourHourly,
                                int pm10SubIndex,
                                int coSubIndex,
                                int pm25TwentyFourHourly,
                                int so2SubIndex,
                                double coEightHourMax,
                                int no2OneHourMax,
                                int so2TwentyFourHourly,
                                int pm25SubIndex,
                                int psiTwentyFourHourly,
                                int o3EightHourMax){

        //        o3_sub_index: 15
//        pm10_twenty_four_hourly: 28
//        pm10_sub_index: 28
//        co_sub_index: 7
//        pm25_twenty_four_hourly: 16
//        so2_sub_index: 5
//        co_eight_hour_max: 0.66
//        no2_one_hour_max: 11
//        so2_twenty_four_hourly: 7
//        pm25_sub_index: 55
//        psi_twenty_four_hourly: 55
//        o3_eight_hour_max:

        TextView o3_sub_index = view.findViewById(R.id.o3_sub_index);
        TextView pm10_twenty_four_hourly = view.findViewById(R.id.pm10_twenty_four_hourly);
        TextView pm10_sub_index = view.findViewById(R.id.pm10_sub_index);
        TextView co_sub_index = view.findViewById(R.id.co_sub_index);
        TextView pm25_twenty_four_hourly = view.findViewById(R.id.pm25_twenty_four_hourly);
        TextView so2_sub_index = view.findViewById(R.id.so2_sub_index);
        TextView co_eight_hour_max = view.findViewById(R.id.co_eight_hour_max);
        TextView no2_one_hour_max = view.findViewById(R.id.no2_one_hour_max);
        TextView so2_twenty_four_hourly = view.findViewById(R.id.so2_twenty_four_hourly);
        TextView pm25_sub_index = view.findViewById(R.id.pm25_sub_index);
        TextView psi_twenty_four_hourly = view.findViewById(R.id.psi_twenty_four_hourly);
        TextView o3_eight_hour_max = view.findViewById(R.id.o3_eight_hour_max);

        o3_sub_index.setText(String.valueOf(o3SubIndex));
        pm10_twenty_four_hourly.setText(String.valueOf(pm10TwentyFourHourly));
        pm10_sub_index.setText(String.valueOf(pm10SubIndex));
        co_sub_index.setText(String.valueOf(coSubIndex));
        pm25_twenty_four_hourly.setText(String.valueOf(pm25TwentyFourHourly));
        so2_sub_index.setText(String.valueOf(so2SubIndex));
        co_eight_hour_max.setText(String.valueOf(coEightHourMax));
        no2_one_hour_max.setText(String.valueOf(no2OneHourMax));
        so2_twenty_four_hourly.setText(String.valueOf(so2TwentyFourHourly));
        pm25_sub_index.setText(String.valueOf(pm25SubIndex));
        psi_twenty_four_hourly.setText(String.valueOf(psiTwentyFourHourly));
        o3_eight_hour_max.setText(String.valueOf(o3EightHourMax));
    }
}
