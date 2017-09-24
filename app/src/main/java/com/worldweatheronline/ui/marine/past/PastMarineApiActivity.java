package com.worldweatheronline.ui.marine.past;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.worldweatheronline.App;
import com.worldweatheronline.R;
import com.worldweatheronline.domain.entity.marine.past.Api;
import java.util.Calendar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @user Kailash Dabhi (kailash09dabhi@gmail.com)
 * @date 19 Sep, 2017 13:05
 */

public final class PastMarineApiActivity extends AppCompatActivity {

  @BindView(R.id.progressBar) ProgressBar progressBar;
  @BindView(R.id.listView) ListView listView;
  @BindView(R.id.latitudeEdit) EditText latitudeEdit;
  @BindView(R.id.longitudeEdit) EditText longitudeEdit;

  @OnClick(R.id.startDateButton)
  void onStartDateButtonClick() {
    pickDate(startDate);
  }

  @OnClick(R.id.endDateButton)
  void onEndDateButtonClick() {
    pickDate(endDate);
  }

  @OnClick(R.id.searchButton)
  void onSearchButtonClick() {
    if (latitudeEdit.length() > 0 && longitudeEdit.length() > 0) {
      fetchPastMarine(latitudeEdit.getText().toString() + "," + longitudeEdit.getText().toString(),
          dateStringOf(startDate),
          dateStringOf(endDate)
      );
    } else {
      Toast.makeText(this, "Pleaes enter the latitude, longitude!", Toast.LENGTH_LONG).show();
    }
  }

  private void pickDate(final Calendar calendar) {
    new DatePickerDialog(PastMarineApiActivity.this,
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
    setContentView(R.layout.activity_past_marine);
    ButterKnife.bind(this);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  private String dateStringOf(Calendar calendar) {
    return calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar
        .get(Calendar.DAY_OF_MONTH);
  }

  private void fetchPastMarine(String latLong, String startDate, String endDate) {
    listView.setVisibility(View.GONE);
    progressBar.setVisibility(View.VISIBLE);

    App.instance().apiService()
        .pastMarineWeather(latLong, startDate, endDate)
        .enqueue(
            new Callback<Api>() {
              @Override public void onResponse(Call<Api> call, Response<Api> response) {
                Api weatherApi = response.body();
                if (weatherApi != null && weatherApi.data != null
                    && weatherApi.data.weather != null) {
                  if (!weatherApi.data.weather.isEmpty()) {
                    listView.setAdapter(
                        new PastMarineAdapter(PastMarineApiActivity.this,
                            weatherApi.data.weather));
                  }

                }
                progressBar.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
              }

              @Override public void onFailure(Call<Api> call, Throwable t) {
                listView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
              }
            }
        );
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
