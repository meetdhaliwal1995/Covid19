package com.example.coronavirusapi.views;

import ModelApi.LatestDate.RegionDate;
import ModelApi.LatestModel.example.LatestCorona;

public interface DateContract {

    interface DateView {

        void showProgress();

        void hideProgress();

        void setLatestDate(RegionDate regionDate);
    }

    interface RegionInteractor {

        void getData();
    }
}