package com.worldweatheronline.ui.apilist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.worldweatheronline.R;
import com.worldweatheronline.ui.marine.MarineApiActivity;
import com.worldweatheronline.ui.marine.past.PastMarineApiActivity;
import com.worldweatheronline.ui.ski.SkiApiActivity;
import com.worldweatheronline.ui.timezone.TimezoneApiActivity;
import com.worldweatheronline.ui.weather.WeatherApiActivity;
import com.worldweatheronline.ui.weather.past.PastWeatherApiActivity;

public final class ApiListActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_api_list);
    findViewById(R.id.weatherButton).setOnClickListener(new OnClickListener() {
      @Override public void onClick(View view) {
        startActivity(new Intent(ApiListActivity.this, WeatherApiActivity.class));
      }
    });
    findViewById(R.id.weatherPastButton).setOnClickListener(new OnClickListener() {
      @Override public void onClick(View view) {
        startActivity(new Intent(ApiListActivity.this, PastWeatherApiActivity.class));
      }
    });
    findViewById(R.id.marineButton).setOnClickListener(new OnClickListener() {
      @Override public void onClick(View view) {
        startActivity(new Intent(ApiListActivity.this, MarineApiActivity.class));
      }
    });
    findViewById(R.id.marinePastButton).setOnClickListener(new OnClickListener() {
      @Override public void onClick(View view) {
        startActivity(new Intent(ApiListActivity.this, PastMarineApiActivity.class));
      }
    });
    findViewById(R.id.skiWeatherButton).setOnClickListener(new OnClickListener() {
      @Override public void onClick(View view) {
        startActivity(new Intent(ApiListActivity.this, SkiApiActivity.class));
      }
    });
    findViewById(R.id.timezoneButton).setOnClickListener(new OnClickListener() {
      @Override public void onClick(View view) {
        startActivity(new Intent(ApiListActivity.this, TimezoneApiActivity.class));
      }
    });
  }
}
