package com.example.coronavirusapi.presenters;

import com.example.coronavirusapi.MyApp;
import com.example.coronavirusapi.NetworkInterface;
import com.example.coronavirusapi.views.RegionContract;

import ModelApi.LatestModel.example.LatestCorona;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegionPresenter implements RegionContract.RegionInteractor {

    private RegionContract.RegionView regionView;

    public RegionPresenter(RegionContract.RegionView regionView) {
        this.regionView = regionView;
    }

    @Override
    public void getData() {
        regionView.showProgress();
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);
        networkInterface.getLatest().enqueue(new Callback<LatestCorona>() {
            @Override
            public void onResponse(Call<LatestCorona> call, Response<LatestCorona> response) {
                regionView.setLatestData(response.body());
                regionView.hideProgress();
            }

            @Override
            public void onFailure(Call<LatestCorona> call, Throwable t) {
                regionView.hideProgress();
            }
        });
    }
}
