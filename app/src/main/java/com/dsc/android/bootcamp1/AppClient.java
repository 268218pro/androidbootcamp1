package com.dsc.android.bootcamp1;


import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppClient {
    // exception! else static always with Public
    // wont be destroyed ever!!! even when closed! runs in background
    //
    private static AppClient mInstance;

    // empty constructor
    private AppClient() {
    }

    // different instances not needed for diff api calls
    public static synchronized AppClient getInstance() {
        // FB/ Wapp = only Register = 2-10 threads : first thread = only UI, one only for logics
        // sync coz not multithreading, single thread, hence queue
        if (mInstance == null) mInstance = new AppClient();
        // new instance created only during First Register!
        return mInstance;
    }

    //templates
    // http?
    // Ok http is a library
    public <S> S createService(Class<S> serviceClass) {
        OkHttpClient.Builder httpClient = getOKHttpClient();
        OkHttpClient client = httpClient.build();

        //Object + static hence . used
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io/").client(client)
                //.baseUrl(BuildConfig.BASE_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create())
                //Google Script Object Notation
                // can convert JSON to string directly
                // not for, while - use async task for huge data
                // AWS better than Hiroku.com
                .build();
        //Base url
        return retrofit.create(serviceClass);
    }

    private OkHttpClient.Builder getOKHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient.addInterceptor(httpLoggingInterceptor);
        }

        httpClient.connectTimeout(15, TimeUnit.SECONDS);
        httpClient.writeTimeout(15, TimeUnit.SECONDS);
        httpClient.readTimeout(15, TimeUnit.SECONDS);

        return httpClient;
    }

}