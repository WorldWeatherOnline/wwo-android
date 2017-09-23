package com.worldweatheronline;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.worldweatheronline.domain.entity.weather.Api;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @user Kailash Dabhi (kailash09dabhi@gmail.com)
 * @date 19 Sep, 2017 13:05
 */

public final class WeatherApiActivity extends AppCompatActivity {

//  @BindView(R.id.jsonView) TextView jsonView;

  @BindView(R.id.progressBar) ProgressBar progressBar;
  @BindView(R.id.currentConditionLayout) CurrentConditionLayout currentConditionLayout;
  @BindView(R.id.screen) View screenView;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_weather);
    ButterKnife.bind(this);
  }

  private void fetchTimezone(String location) {
    screenView.setVisibility(View.GONE);
    progressBar.setVisibility(View.VISIBLE);

    App.instance().apiService().weather(location)
        .enqueue(new Callback<Api>() {
          @Override public void onResponse(Call<Api> call, Response<Api> response) {
            com.worldweatheronline.domain.entity.weather.Api weather = response.body();
            if (weather != null) {
//              jsonView.setText(weather.toString());
              currentConditionLayout.bind(weather.data.currentCondition.get(0));
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
