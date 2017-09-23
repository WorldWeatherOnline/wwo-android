package com.worldweatheronline.ui.weather.past;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.worldweatheronline.App;
import com.worldweatheronline.R;
import java.util.Calendar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @user Kailash Dabhi (kailash09dabhi@gmail.com)
 * @date 19 Sep, 2017 13:05
 */

public final class PastWeatherApiActivity extends AppCompatActivity {

  @BindView(R.id.progressBar) ProgressBar progressBar;
  @BindView(R.id.screen) View screenView;
  @BindView(R.id.listView) ListView listView;

  private void pickDate(final Calendar calendar) {
    new DatePickerDialog(PastWeatherApiActivity.this,
        new OnDateSetListener() {
          @Override public void onDateSet(DatePicker datePicker, int year, int monthOfYear,
              int dayOfMonth) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, monthOfYear);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
          }
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    ).show();
  }

  Calendar startDate = Calendar.getInstance();
  Calendar endDate = Calendar.getInstance();

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_past_weather);
    ButterKnife.bind(this);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  private String dateStringOf(Calendar calendar) {
    return calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar
        .get(Calendar.DAY_OF_MONTH);
  }

  private void fetchTimezone(String location) {
    screenView.setVisibility(View.GONE);
    progressBar.setVisibility(View.VISIBLE);

    App.instance().apiService()
        .pastWeather(location, dateStringOf(startDate), dateStringOf(endDate))
        .enqueue(

            new Callback<com.worldweatheronline.domain.entity.weather.past.Api>() {
              @Override public void onResponse(
                  Call<com.worldweatheronline.domain.entity.weather.past.Api> call,
                  Response<com.worldweatheronline.domain.entity.weather.past.Api> response) {
                com.worldweatheronline.domain.entity.weather.past.Api weatherApi = response.body();
                if (weatherApi != null && weatherApi.data != null
                    && weatherApi.data.weather != null) {
                  if (!weatherApi.data.weather.isEmpty()) {
                    listView.setAdapter(
                        new PastWeatherAdapter(PastWeatherApiActivity.this,
                            weatherApi.data.weather));
                  }

                }
                progressBar.setVisibility(View.GONE);
                screenView.setVisibility(View.VISIBLE);
              }

              @Override public void onFailure(
                  Call<com.worldweatheronline.domain.entity.weather.past.Api> call, Throwable t) {
                screenView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
              }
            }

        );
  }

  private Menu menu;

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    this.menu = menu;
    getMenuInflater().inflate(R.menu.past_weather_menu, menu);
    final MenuItem item = menu.findItem(R.id.action_search);
    item.setOnActionExpandListener(new OnActionExpandListener() {
      @Override public boolean onMenuItemActionExpand(MenuItem menuItem) {
        hideAction(R.id.action_pick_start_date);
        hideAction(R.id.action_pick_end_date);
        return true;
      }

      @Override public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        showAction(R.id.action_pick_start_date);
        showAction(R.id.action_pick_end_date);
        return true;
      }
    });

    SearchManager searchManager =
        (SearchManager) getSystemService(Context.SEARCH_SERVICE);
    final SearchView searchView =
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

  private void hideAction(int id) {
    menu.findItem(id).setVisible(false);
  }

  private void showAction(int id) {
    menu.findItem(id).setVisible(true);
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        return true;
      case R.id.action_pick_start_date:
        pickDate(startDate);
        return true;
      case R.id.action_pick_end_date:
        pickDate(endDate);
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }

  }
}
