package com.example.coronavirusapi;

import ModelApi.LatestDate.DateList;
import ModelApi.LatestModel.example.LatestCorona;
import ModelApi.LatestModel.example.RegionInfo;

public interface InterfaceContent {

    default void getRegionInfo(RegionInfo regionInfo) {
    }



    default void getDateInfo(DateList dateList) {
    }
}
