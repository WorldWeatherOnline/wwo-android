package com.worldweatheronline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

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
  }
}
