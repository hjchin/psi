package psi.com.psi.map;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import psi.com.psi.R;
import psi.com.psi.data.psi.PsiResponse;

import static junit.framework.Assert.assertEquals;

/**
 * Created by HJ Chin on 12/12/2017.
 */

@RunWith(RobolectricTestRunner.class)
public class InfoWindowTest {


    @Test
    public void testInfoWindow(){

        MapsActivity activity = Robolectric.setupActivity(MapsActivity.class);

        String response = "{\"region_metadata\":[{\"name\":\"west\",\"label_location\":{\"latitude\":1.35735,\"longitude\":103.7}},{\"name\":\"national\",\"label_location\":{\"latitude\":0,\"longitude\":0}},{\"name\":\"east\",\"label_location\":{\"latitude\":1.35735,\"longitude\":103.94}},{\"name\":\"central\",\"label_location\":{\"latitude\":1.35735,\"longitude\":103.82}},{\"name\":\"south\",\"label_location\":{\"latitude\":1.29587,\"longitude\":103.82}},{\"name\":\"north\",\"label_location\":{\"latitude\":1.41803,\"longitude\":103.82}}],\"items\":[{\"timestamp\":\"2017-12-12T09:00:00+08:00\",\"update_timestamp\":\"2017-12-12T09:06:19+08:00\",\"readings\":{\"o3_sub_index\":{\"west\":15,\"national\":15,\"east\":12,\"central\":11,\"south\":13,\"north\":5},\"pm10_twenty_four_hourly\":{\"west\":28,\"national\":41,\"east\":41,\"central\":26,\"south\":29,\"north\":31},\"pm10_sub_index\":{\"west\":28,\"national\":41,\"east\":41,\"central\":26,\"south\":29,\"north\":31},\"co_sub_index\":{\"west\":7,\"national\":8,\"east\":4,\"central\":8,\"south\":7,\"north\":6},\"pm25_twenty_four_hourly\":{\"west\":16,\"national\":22,\"east\":22,\"central\":16,\"south\":15,\"north\":17},\"so2_sub_index\":{\"west\":5,\"national\":5,\"east\":2,\"central\":3,\"south\":2,\"north\":3},\"co_eight_hour_max\":{\"west\":0.66,\"national\":0.78,\"east\":0.45,\"central\":0.78,\"south\":0.66,\"north\":0.62},\"no2_one_hour_max\":{\"west\":11,\"national\":44,\"east\":34,\"central\":44,\"south\":44,\"north\":33},\"so2_twenty_four_hourly\":{\"west\":7,\"national\":7,\"east\":3,\"central\":4,\"south\":3,\"north\":5},\"pm25_sub_index\":{\"west\":55,\"national\":62,\"east\":62,\"central\":56,\"south\":54,\"north\":57},\"psi_twenty_four_hourly\":{\"west\":55,\"national\":62,\"east\":62,\"central\":56,\"south\":54,\"north\":57},\"o3_eight_hour_max\":{\"west\":36,\"national\":36,\"east\":27,\"central\":26,\"south\":30,\"north\":12}}}],\"api_info\":{\"status\":\"healthy\"}}";
        PsiResponse psiResponse = new Gson().fromJson(response,PsiResponse.class);

        View view =  LayoutInflater.from(activity.getApplicationContext()).inflate(R.layout.psi_reading, null);
        activity.fillInfoWindow(
            view,
                psiResponse.items.get(0).readings.o3SubIndex.north,
                psiResponse.items.get(0).readings.pm10TwentyFourHourly.north,
                psiResponse.items.get(0).readings.pm10SubIndex.north,
                psiResponse.items.get(0).readings.coSubIndex.north,
                psiResponse.items.get(0).readings.pm25TwentyFourHourly.north,
                psiResponse.items.get(0).readings.so2SubIndex.north,
                psiResponse.items.get(0).readings.coEightHourMax.north,
                psiResponse.items.get(0).readings.no2OneHourMax.north,
                psiResponse.items.get(0).readings.so2TwentyFourHourly.north,
                psiResponse.items.get(0).readings.pm25SubIndex.north,
                psiResponse.items.get(0).readings.psiTwentyFourHourly.north,
                psiResponse.items.get(0).readings.o3EightHourMax.north
        );

        assertEquals(((TextView)view.findViewById(R.id.o3_sub_index)).getText().toString(),
                String.valueOf(psiResponse.items.get(0).readings.o3SubIndex.north));

        assertEquals(((TextView)view.findViewById(R.id.pm10_twenty_four_hourly)).getText().toString(),
                String.valueOf(psiResponse.items.get(0).readings.pm10TwentyFourHourly.north));

        assertEquals(((TextView)view.findViewById(R.id.pm10_sub_index)).getText().toString(),
                String.valueOf(psiResponse.items.get(0).readings.pm10SubIndex.north));

        assertEquals(((TextView)view.findViewById(R.id.co_sub_index)).getText().toString(),
                String.valueOf(psiResponse.items.get(0).readings.coSubIndex.north));

        assertEquals(((TextView)view.findViewById(R.id.pm25_twenty_four_hourly)).getText().toString(),
                String.valueOf(psiResponse.items.get(0).readings.pm25TwentyFourHourly.north));

        assertEquals(((TextView)view.findViewById(R.id.so2_sub_index)).getText().toString(),
                String.valueOf(psiResponse.items.get(0).readings.so2SubIndex.north));

        assertEquals(((TextView)view.findViewById(R.id.co_eight_hour_max)).getText().toString(),
                String.valueOf(psiResponse.items.get(0).readings.coEightHourMax.north));

        assertEquals(((TextView)view.findViewById(R.id.no2_one_hour_max)).getText().toString(),
                String.valueOf(psiResponse.items.get(0).readings.no2OneHourMax.north));

        assertEquals(((TextView)view.findViewById(R.id.so2_twenty_four_hourly)).getText().toString(),
                String.valueOf(psiResponse.items.get(0).readings.so2TwentyFourHourly.north));

        assertEquals(((TextView)view.findViewById(R.id.pm25_sub_index)).getText().toString(),
                String.valueOf(psiResponse.items.get(0).readings.pm25SubIndex.north));

        assertEquals(((TextView)view.findViewById(R.id.psi_twenty_four_hourly)).getText().toString(),
                String.valueOf(psiResponse.items.get(0).readings.psiTwentyFourHourly.north));

        assertEquals(((TextView)view.findViewById(R.id.o3_eight_hour_max)).getText().toString(),
                String.valueOf(psiResponse.items.get(0).readings.o3EightHourMax.north));
    }
}
