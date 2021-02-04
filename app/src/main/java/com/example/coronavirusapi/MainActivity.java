package com.example.coronavirusapi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ModelApi.LatestModel.example.LatestCorona;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageView more;
    TextView number, active, death, recovered, critical, tested, deathRatio, recoverdRatio;
    TextView text1, text, text3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_change);

//        number = findViewById(R.id.text_number);
//        active = findViewById(R.id.text_activenumber);
//        death = findViewById(R.id.text_death);
//        recovered = findViewById(R.id.text_recovered);
//        critical = findViewById(R.id.text_critical);
//        tested = findViewById(R.id.text_tested);
//        deathRatio = findViewById(R.id.text_death_ratio);
//        recoverdRatio = findViewById(R.id.text_recovery_ratio);
//        more = findViewById(R.id.more_iv);


        text = findViewById(R.id.confirm_case);
        text1 = findViewById(R.id.recoverd_case);
        text3 = findViewById(R.id.deceased_case);

        retrofit2();

//        more.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                menuPopUp();
//            }
//        });

    }

    public void retrofit() {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);

        networkInterface.getLatest().enqueue(new Callback<LatestCorona>() {
            @Override
            public void onResponse(Call<LatestCorona> call, Response<LatestCorona> response) {
                LatestCorona latestCorona = response.body();
                Log.e("fff", String.valueOf(response.body()));
                number.setText(String.valueOf(latestCorona.getData().getSummary().getTotalCases()));
                active.setText(String.valueOf(latestCorona.getData().getSummary().getActiveCases()));
                death.setText(String.valueOf(latestCorona.getData().getSummary().getDeaths()));
                recovered.setText(String.valueOf(latestCorona.getData().getSummary().getRecovered()));
                critical.setText(String.valueOf(latestCorona.getData().getSummary().getCritical()));
                tested.setText(String.valueOf(latestCorona.getData().getSummary().getTested()));
                deathRatio.setText(String.valueOf(latestCorona.getData().getSummary().getDeathRatio()));
                recoverdRatio.setText(String.valueOf(latestCorona.getData().getSummary().getRecoveryRatio()));
            }

            @Override
            public void onFailure(Call<LatestCorona> call, Throwable t) {

            }
        });


    }

    public void menuPopUp() {
        PopupMenu popupMenu = new PopupMenu(this, more);
        popupMenu.inflate(R.menu.menu_popup);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.memu_1:
                        Intent intent = new Intent(MainActivity.this, FragmentRegionl.class);
                        startActivity(intent);
                        break;
                    case R.id.menu_2:
                        Intent intent1 = new Intent(MainActivity.this, FragmentChange.class);
                        startActivity(intent1);
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    public void retrofit2() {
        NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);

        networkInterface.getLatest().enqueue(new Callback<LatestCorona>() {
            @Override
            public void onResponse(Call<LatestCorona> call, Response<LatestCorona> response) {
                LatestCorona latestCorona = response.body();
                Log.e("fff", String.valueOf(response.body()));
                text.setText(String.valueOf(latestCorona.getData().getSummary().getTotalCases()));
                text3.setText(String.valueOf(latestCorona.getData().getSummary().getDeaths()));
                text1.setText(String.valueOf(latestCorona.getData().getSummary().getRecovered()));
            }

            @Override
            public void onFailure(Call<LatestCorona> call, Throwable t) {

            }
        });

    }
}