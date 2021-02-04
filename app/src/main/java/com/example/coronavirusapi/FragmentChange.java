package com.example.coronavirusapi;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ModelApi.LatestModel.example.LatestCorona;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentChange extends Fragment {

    ImageView more;
    TextView number, active, death, recovered, critical, tested, deathRatio, recoverdRatio;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_change, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        number = view.findViewById(R.id.text_number);
        active = view.findViewById(R.id.text_activenumber);
        death = view.findViewById(R.id.text_death);
        recovered = view.findViewById(R.id.text_recovered);
        critical = view.findViewById(R.id.text_critical);
        tested = view.findViewById(R.id.text_tested);
        deathRatio = view.findViewById(R.id.text_death_ratio);
        recoverdRatio = view.findViewById(R.id.text_recovery_ratio);


        retrofit();
    }

    public void retrofit() {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);

        networkInterface.getLatest().enqueue(new Callback<LatestCorona>() {
            @Override
            public void onResponse(Call<LatestCorona> call, Response<LatestCorona> response) {
                LatestCorona latestCorona = response.body();
                Log.e("fff", String.valueOf(response.body()));
                number.setText(String.valueOf(latestCorona.getData().getChange().getTotalCases()));
                active.setText(String.valueOf(latestCorona.getData().getChange().getActiveCases()));
                death.setText(String.valueOf(latestCorona.getData().getChange().getDeaths()));
                recovered.setText(String.valueOf(latestCorona.getData().getChange().getRecovered()));
                critical.setText(String.valueOf(latestCorona.getData().getChange().getCritical()));
                tested.setText(String.valueOf(latestCorona.getData().getChange().getTested()));
                deathRatio.setText(String.valueOf(latestCorona.getData().getChange().getDeathRatio()).substring(0,8));
                recoverdRatio.setText(String.valueOf(latestCorona.getData().getChange().getRecoveryRatio()).substring(0,5));
            }

            @Override
            public void onFailure(Call<LatestCorona> call, Throwable t) {

            }
        });
    }
}
