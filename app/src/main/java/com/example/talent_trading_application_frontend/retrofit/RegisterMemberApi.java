package com.example.talent_trading_application_frontend.retrofit;

import com.example.talent_trading_application_frontend.domain.Member;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegisterMemberApi {

    @POST("/members/save")
    Call<Member> save(@Body Member member);
}
