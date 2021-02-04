package com.example.coronavirusapi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coronavirusapi.presenters.RegionPresenter;
import com.example.coronavirusapi.views.RegionContract;

import java.util.ArrayList;
import java.util.List;

import ModelApi.LatestModel.example.LatestCorona;
import ModelApi.LatestModel.example.RegionInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentRegionl extends Fragment implements InterfaceContent, RegionContract.RegionView {

    RecyclerView recyclerView;
    TextView text1, text2;
    ProgressBar progressBar;
    RegionPresenter regionPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        progressBar = view.findViewById(R.id.spin_kit_re);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        regionPresenter = new RegionPresenter(this);
        regionPresenter.getData();
    }

    @Override
    public void getRegionInfo(RegionInfo regionInfo) {
        FragmetSingleRegion fragmetSingleRegion = new FragmetSingleRegion();
        fragmetSingleRegion.setRegionInfo(regionInfo);
        getParentFragmentManager().beginTransaction().
                setCustomAnimations(R.anim.slide_in_right, R.anim.slide_in_left)
                .add(R.id.container_layout, fragmetSingleRegion)
                .addToBackStack("df")
                .commit();
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
    public void setLatestData(LatestCorona latestCorona) {
        List<RegionInfo> _list = new ArrayList<>();
        _list.addAll(latestCorona.getData().getRegions().values());
        AdapterRegion adapterRegion = new AdapterRegion(getContext(), _list, FragmentRegionl.this);
        recyclerView.setAdapter(adapterRegion);
    }
}