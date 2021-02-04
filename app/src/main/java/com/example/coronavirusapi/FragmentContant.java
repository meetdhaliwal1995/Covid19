package com.example.coronavirusapi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.coronavirusapi.presenters.RegionPresenter;
import com.example.coronavirusapi.views.RegionContract;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;

import ModelApi.LatestModel.example.LatestCorona;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentContant extends Fragment implements RegionContract.RegionView {

    TextView recover, confirm, deceased, confirmText, deceasedText, recoverText;
    ProgressBar progressBar;
    ImageView image;
    RegionPresenter regionPresenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_main2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        confirm = view.findViewById(R.id.confirm_case);
        recover = view.findViewById(R.id.recoverd_case);
        deceased = view.findViewById(R.id.deceased_case);
        confirmText = view.findViewById(R.id.confirm_text);
        recoverText = view.findViewById(R.id.recoverd_text);
        deceasedText = view.findViewById(R.id.deceased_text);
        image = view.findViewById(R.id.image_back);


        progressBar = view.findViewById(R.id.spin_kit);
        regionPresenter = new RegionPresenter(this);
        regionPresenter.getData();

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
        confirm.setText(String.valueOf(latestCorona.getData().getSummary().getTotalCases()));
        confirmText.setText("Confirmed Case");
        deceased.setText(String.valueOf(latestCorona.getData().getSummary().getDeaths()));
        deceasedText.setText("Deceased case");
        recover.setText(String.valueOf(latestCorona.getData().getSummary().getRecovered()));
        recoverText.setText("Recovered Case");
    }
}
