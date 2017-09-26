package com.worldweatheronline.ui.weather;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.worldweatheronline.App;
import com.worldweatheronline.ui.CurrentConditionLayout;
import com.worldweatheronline.R;
import com.worldweatheronline.domain.entity.weather.Api;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @user Kailash Dabhi (kailash09dabhi@gmail.com)
 * @date 19 Sep, 2017 13:05
 */

public final class WeatherApiActivity extends AppCompatActivity {

  @BindView(R.id.progressBar) ProgressBar progressBar;
  @BindView(R.id.currentConditionLayout) CurrentConditionLayout currentConditionLayout;
  @BindView(R.id.screen) View screenView;
  @BindView(R.id.listView) ListView listView;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_weather);
    ButterKnife.bind(this);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  private void fetchTimezone(String location) {
    screenView.setVisibility(View.GONE);
    progressBar.setVisibility(View.VISIBLE);

    App.instance().apiService().weather(location)
        .enqueue(new Callback<Api>() {
          @Override public void onResponse(Call<Api> call, Response<Api> response) {
            com.worldweatheronline.domain.entity.weather.Api weatherApi = response.body();
            if (weatherApi != null && weatherApi.data != null) {
              if (weatherApi.data.currentCondition != null && !weatherApi.data.currentCondition
                  .isEmpty()) {
                currentConditionLayout.bind(weatherApi.data.currentCondition.get(0));
              }
              if (weatherApi.data.weather != null && !weatherApi.data.weather.isEmpty()) {
                listView.setAdapter(
                    new WeatherAdapter(WeatherApiActivity.this, weatherApi.data.weather));
              }

            }
            progressBar.setVisibility(View.GONE);
            screenView.setVisibility(View.VISIBLE);
          }

          @Override
          public void onFailure(Call<com.worldweatheronline.domain.entity.weather.Api> call,
              Throwable t) {
            screenView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
          }
        });
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu, menu);
    final MenuItem item = menu.findItem(R.id.action_search);

    SearchManager searchManager =
        (SearchManager) getSystemService(Context.SEARCH_SERVICE);
    SearchView searchView =
        (SearchView) item.getActionView();
    searchView.setSearchableInfo(
        searchManager.getSearchableInfo(getComponentName()));
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override public boolean onQueryTextSubmit(String query) {
        fetchTimezone(query);
        return true;
      }

      @Override public boolean onQueryTextChange(String newText) {
        return false;
      }
    });
    searchView.setQuery("Paris", true);
    searchView.setQueryHint("Search by city");
    return true;
  }
}
