package com.worldweatheronline.ui.ski;

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
import android.widget.Toast;
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

public final class SkiApiActivity extends AppCompatActivity {

  @BindView(R.id.progressBar) ProgressBar progressBar;
  @BindView(R.id.listView) ListView listView;
  @BindView(R.id.latitudeEdit) EditText latitudeEdit;
  @BindView(R.id.longitudeEdit) EditText longitudeEdit;

  @OnClick(R.id.searchButton)
  void onSearchButtonClick() {
    if (latitudeEdit.length() > 0 && longitudeEdit.length() > 0) {
      fetchSki(latitudeEdit.getText().toString() + "," + longitudeEdit.getText().toString());
    } else {
      Toast.makeText(this, "Pleaes enter the latitude, longitude!", Toast.LENGTH_LONG).show();
    }
  }
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_marine);
    ButterKnife.bind(this);
  }

  private void fetchSki(String location) {
    listView.setVisibility(View.GONE);
    progressBar.setVisibility(View.VISIBLE);

    App.instance().apiService().skiWeather(location)
        .enqueue(

            new Callback<com.worldweatheronline.domain.entity.ski.Api>() {
              @Override
              public void onResponse(Call<com.worldweatheronline.domain.entity.ski.Api> call,
                  Response<com.worldweatheronline.domain.entity.ski.Api> response) {
                com.worldweatheronline.domain.entity.ski.Api weatherApi = response.body();
                if (weatherApi != null && weatherApi.data != null) {
                  if (weatherApi.data.weather != null && !weatherApi.data.weather.isEmpty()) {
                    listView.setAdapter(
                        new SkiAdapter(SkiApiActivity.this, weatherApi.data.weather));
                  }

                }
                progressBar.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
              }

              @Override
              public void onFailure(Call<com.worldweatheronline.domain.entity.ski.Api> call,
                  Throwable t) {
                listView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
              }
            }
        );
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
        fetchSki(query);
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
