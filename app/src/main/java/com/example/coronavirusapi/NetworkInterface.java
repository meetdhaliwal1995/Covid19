package com.example.coronavirusapi;

import ModelApi.LatestDate.RegionDate;
import ModelApi.LatestModel.example.LatestCorona;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkInterface {


    @GET(Constant.LATEST)
    Call<LatestCorona> getLatest();

    @GET(Constant.YEARDATA)
    Call<RegionDate> getRegion(@Query("region") String region);

}
