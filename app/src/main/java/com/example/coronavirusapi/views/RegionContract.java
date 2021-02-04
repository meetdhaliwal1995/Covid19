package com.example.coronavirusapi.views;

import ModelApi.LatestModel.example.LatestCorona;

public interface RegionContract {

    interface RegionView {

        void showProgress();

        void hideProgress();

        void setLatestData(LatestCorona latestCorona);
    }

    interface RegionInteractor {

        void getData();
    }
}