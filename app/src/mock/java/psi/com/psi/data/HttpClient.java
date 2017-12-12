package psi.com.psi.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HJ Chin on 11/12/2017.
 */

public class HttpClient implements HttpClientInterface {

    private static HttpClient client;

    private Retrofit retrofit;
    private String baseUrl = "https://api.data.gov.sg/v1/";
    private static final String MOCK_RESPONSE = "{\"region_metadata\":[{\"name\":\"west\",\"label_location\":{\"latitude\":1.35735,\"longitude\":103.7}},{\"name\":\"national\",\"label_location\":{\"latitude\":0,\"longitude\":0}},{\"name\":\"east\",\"label_location\":{\"latitude\":1.35735,\"longitude\":103.94}},{\"name\":\"central\",\"label_location\":{\"latitude\":1.35735,\"longitude\":103.82}},{\"name\":\"south\",\"label_location\":{\"latitude\":1.29587,\"longitude\":103.82}},{\"name\":\"north\",\"label_location\":{\"latitude\":1.41803,\"longitude\":103.82}}],\"items\":[{\"timestamp\":\"2017-12-12T09:00:00+08:00\",\"update_timestamp\":\"2017-12-12T09:06:19+08:00\",\"readings\":{\"o3_sub_index\":{\"west\":15,\"national\":15,\"east\":12,\"central\":11,\"south\":13,\"north\":5},\"pm10_twenty_four_hourly\":{\"west\":28,\"national\":41,\"east\":41,\"central\":26,\"south\":29,\"north\":31},\"pm10_sub_index\":{\"west\":28,\"national\":41,\"east\":41,\"central\":26,\"south\":29,\"north\":31},\"co_sub_index\":{\"west\":7,\"national\":8,\"east\":4,\"central\":8,\"south\":7,\"north\":6},\"pm25_twenty_four_hourly\":{\"west\":16,\"national\":22,\"east\":22,\"central\":16,\"south\":15,\"north\":17},\"so2_sub_index\":{\"west\":5,\"national\":5,\"east\":2,\"central\":3,\"south\":2,\"north\":3},\"co_eight_hour_max\":{\"west\":0.66,\"national\":0.78,\"east\":0.45,\"central\":0.78,\"south\":0.66,\"north\":0.62},\"no2_one_hour_max\":{\"west\":11,\"national\":44,\"east\":34,\"central\":44,\"south\":44,\"north\":33},\"so2_twenty_four_hourly\":{\"west\":7,\"national\":7,\"east\":3,\"central\":4,\"south\":3,\"north\":5},\"pm25_sub_index\":{\"west\":55,\"national\":62,\"east\":62,\"central\":56,\"south\":54,\"north\":57},\"psi_twenty_four_hourly\":{\"west\":55,\"national\":62,\"east\":62,\"central\":56,\"south\":54,\"north\":57},\"o3_eight_hour_max\":{\"west\":36,\"national\":36,\"east\":27,\"central\":26,\"south\":30,\"north\":12}}}],\"api_info\":{\"status\":\"healthy\"}}";

    private HttpClient() {
    }

    public static HttpClientInterface getInstance() {
        if (client == null) {
            client = new HttpClient();
        }

        return client;
    }

    @Override
    public Retrofit getClient() {
        if (retrofit == null) {

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(new Interceptor());
            httpClient.addInterceptor(logging);

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient.build())
                    .build();
        }

        return retrofit;
    }

    /*
        intercept to fake response for local testing

     */
    private static class Interceptor implements okhttp3.Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {

            URI uri = chain.request().url().uri();
            String responseString = "";
            switch(uri.getPath()){
                case "/v1/environment/psi":
                    responseString = createPSIresponse();
                    break;
            }

            Response response = new Response.Builder()
                    .code(200)
                    .message(responseString)
                    .request(chain.request())
                    .protocol(Protocol.HTTP_1_0)
                    .body(ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes()))
                    .addHeader("content-type", "application/json")
                    .build();

            return response;
        }

        private String createPSIresponse(){
            return MOCK_RESPONSE;
        }
    }
}
