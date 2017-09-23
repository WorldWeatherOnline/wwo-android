package com.worldweatheronline.ui.marine;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.worldweatheronline.App;
import com.worldweatheronline.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @user Kailash Dabhi (kailash09dabhi@gmail.com)
 * @date 19 Sep, 2017 13:05
 */

public final class MarineApiActivity extends AppCompatActivity {

  @BindView(R.id.progressBar) ProgressBar progressBar;
  @BindView(R.id.screen) View screenView;
  @BindView(R.id.listView) ListView listView;
  @BindView(R.id.latitudeEdit) EditText latitudeEdit;
  @BindView(R.id.longitudeEdit) EditText longitudeEdit;

  @OnClick(R.id.searchButton)
  void onSearchButtonClick() {
    fetchMarine(latitudeEdit.getText().toString() + "," + longitudeEdit.getText().toString());
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_marine);
    ButterKnife.bind(this);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  private void fetchMarine(String latLong) {
    screenView.setVisibility(View.GONE);
    progressBar.setVisibility(View.VISIBLE);

    App.instance().apiService().marine(latLong)
        .enqueue(new Callback<com.worldweatheronline.domain.entity.marine.Api>() {
          @Override
          public void onResponse(Call<com.worldweatheronline.domain.entity.marine.Api> call,
              Response<com.worldweatheronline.domain.entity.marine.Api> response) {
            com.worldweatheronline.domain.entity.marine.Api marineApi = response.body();
            if (marineApi != null && marineApi.data != null && marineApi.data.weather != null) {

              if (!marineApi.data.weather.isEmpty()) {
                listView.setAdapter(
                    new MarineAdapter(MarineApiActivity.this, marineApi.data.weather));
              }

            }
            progressBar.setVisibility(View.GONE);
            screenView.setVisibility(View.VISIBLE);
          }

          @Override
          public void onFailure(Call<com.worldweatheronline.domain.entity.marine.Api> call,
              Throwable t) {
            screenView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
          }
        });
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }
}
