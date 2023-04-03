package com.example.talent_trading_application_frontend.retrofit;

import com.example.talent_trading_application_frontend.domain.Member;
import com.example.talent_trading_application_frontend.dto.LoginDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApi {

    @POST("/members/login")
    Call<LoginDTO> login(@Body LoginDTO loginDTO);
}
