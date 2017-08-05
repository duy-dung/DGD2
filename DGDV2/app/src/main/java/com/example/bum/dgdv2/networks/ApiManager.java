package com.example.bum.dgdv2.networks;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bum on 22-Jul-17.
 */

public class ApiManager {
    public static final String MY_API="";
    private MyApi myApi;
    public ApiManager() {
        init();
    }

    private void init() {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(MY_API);
        OkHttpClient defaultHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder()
                                .build();
                        return chain.proceed(request);
                    }
                })
                .connectTimeout(5, TimeUnit.MINUTES)
                .build();

        builder.client(defaultHttpClient);
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        myApi = retrofit.create(MyApi.class);
    }


}
