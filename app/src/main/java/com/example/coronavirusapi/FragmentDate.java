package com.example.coronavirusapi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coronavirusapi.presenters.DatePresenter;
import com.example.coronavirusapi.views.DateContract;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ModelApi.LatestDate.DateList;
import ModelApi.LatestDate.RegionDate;

public class FragmentDate extends Fragment implements InterfaceContent, DateContract.DateView {

    RecyclerView recyclerView;
    String regionName;
    ProgressBar progressBar;
    DatePresenter datePresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler_date, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);

        progressBar = view.findViewById(R.id.spin_kit_re);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        datePresenter = new DatePresenter(this);
        datePresenter.getData();
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public void getDateInfo(DateList dateList) {
//        FragmentSingleDate fragmentSingleDate = new FragmentSingleDate();
        datePresenter.setDateList(dateList);
//        getParentFragmentManager().beginTransaction()
//                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_in_left)
//                .add(R.id.container_layout, fragmentSingleDate)
//                .addToBackStack("df")
//                .commit();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setLatestDate(RegionDate regionDate) {
        List<DateList> keyValue = new ArrayList<>();
        Map<String, DateList> map = regionDate.getData();
        for (String s : regionDate.getData().keySet()) {
            DateList v = map.get(s);
            v.setDate(s);
            keyValue.add(v);
            progressBar.setVisibility(View.GONE);
            AdapterDate adapterDate = new AdapterDate(getContext(), keyValue, FragmentDate.this);
            recyclerView.setAdapter(adapterDate);
        }
    }
}
