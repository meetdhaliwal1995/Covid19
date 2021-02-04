package com.example.coronavirusapi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ModelApi.LatestDate.DateList;

public class FragmentSingleDate extends Fragment {

    TextView total, death, recover, name, country, info;
    DateList dateList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_single_date, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        total = view.findViewById(R.id.confirm_case);
        recover = view.findViewById(R.id.recoverd_case);
        death = view.findViewById(R.id.deceased_case);
        name = view.findViewById(R.id.country_name);
        info = view.findViewById(R.id.text_more);


        total.setText(String.valueOf(dateList.getTotalCases()));
        name.setText(String.valueOf(dateList.getDate()));
        death.setText(String.valueOf(dateList.getDeaths()));
        recover.setText(String.valueOf(dateList.getRecovered()));


    }

    public void setDateList(DateList dateList) {
        this.dateList = dateList;
    }
}
