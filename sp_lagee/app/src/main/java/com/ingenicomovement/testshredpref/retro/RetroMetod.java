package com.ingenicomovement.testshredpref.retro;

import com.ingenicomovement.testshredpref.pojo.UserLoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetroMetod {

    @FormUrlEncoded
    @POST("api/auth/login")
    Call<UserLoginResponse> loginUserTech(@Field("username") String username,
                                          @Field("password") String password,
                                          @Field("dateTime") String dateTime,
                                          @Field("signature") String signature);

}
