package psi.com.psi.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HJ Chin on 11/12/2017.
 */

public class HttpClient implements HttpClientInterface {

    private static HttpClient client;

    private Retrofit retrofit;
    private final String baseUrl = "https://api.data.gov.sg/v1/";

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
            httpClient.addInterceptor(logging);

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient.build())
                    .build();
        }

        return retrofit;
    }

}
