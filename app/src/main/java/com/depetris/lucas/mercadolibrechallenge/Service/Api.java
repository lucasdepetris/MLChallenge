package com.depetris.lucas.mercadolibrechallenge.Service;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static Api instance = null;
    public static final String BASE_URL = "https://api.mercadolibre.com/sites/MLA/";
    private final static Integer TIMEOUT = 90000;
    private final static Integer MAX_RETRIES = 3;
    // Keep your services here, build them in buildRetrofit method later
    private ApiMercadolibre apiService;

    public static Api getInstance() {
        if (instance == null) {
            instance = new Api();
        }

        return instance;
    }

    // Build retrofit once when creating a single instance
    private Api() {
        // Implement a method to build your retrofit
        buildRetrofit(BASE_URL);
    }

    private void buildRetrofit(String BASE_URL) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .baseUrl(BASE_URL)
                .build();
        this.apiService = retrofit.create(ApiMercadolibre.class);
    }

    public ApiMercadolibre getApiService() {
        return this.apiService;
    }
}
