package com.example.talent_trading_application_frontend.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private Retrofit retrofit;

    public RetrofitService()
    {
        initializeRetrofit();
    }

    private void initializeRetrofit() {
        retrofit=new Retrofit.Builder()
                .baseUrl("서버IP주소+포트번호")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public Retrofit getRetrofit()
    {
        return retrofit;
    }
}

