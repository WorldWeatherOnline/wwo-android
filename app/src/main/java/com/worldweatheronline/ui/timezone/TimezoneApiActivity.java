package com.worldweatheronline.ui.timezone;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.worldweatheronline.App;
import com.worldweatheronline.ui.NearestAreaLayout;
import com.worldweatheronline.R;
import com.worldweatheronline.domain.entity.timezone.Api;
import com.worldweatheronline.domain.entity.timezone.TimeZone;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @user Kailash Dabhi (kailash09dabhi@gmail.com)
 * @date 19 Sep, 2017 13:05
 */

public final class TimezoneApiActivity extends AppCompatActivity {

  @BindView(R.id.nearestAreaLayout) NearestAreaLayout nearestAreaLayout;
  @BindView(R.id.localTimeView) TextView localTimeView;
  @BindView(R.id.utcOffetView) TextView utcOffsetView;
  @BindView(R.id.progressBar) ProgressBar progressBar;
  @BindView(R.id.screen) View screenView;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_timezone);
    ButterKnife.bind(this);
  }

  private void fetchTimezone(String location) {
    screenView.setVisibility(View.GONE);
    progressBar.setVisibility(View.VISIBLE);
    App.instance().apiService().timezone(location).enqueue(new Callback<Api>() {
      @Override public void onResponse(Call<Api> call, Response<Api> response) {
        Api body = response.body();
        if (body != null && body.data != null && !body.data.timeZone.isEmpty()
            && !body.data.nearestArea.isEmpty()) {
          TimeZone timezone = body.data.timeZone.get(0);
          if (timezone != null) {
            localTimeView.setText("Local time is " + timezone.localtime);
            utcOffsetView.setText("Utc Offset is " + timezone.utcOffset);
            nearestAreaLayout.bind(body.data.nearestArea.get(0));
          }
        }
        progressBar.setVisibility(View.GONE);
        screenView.setVisibility(View.VISIBLE);
      }

      @Override public void onFailure(Call<Api> call, Throwable t) {
        screenView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
      }
    });
  }

  public void hideKeyboard() {
    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
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
//    searchView.setIconifiedByDefault(false);
//    searchView.setSubmitButtonEnabled(true);
    searchView.setQueryHint("Search by city");
    return true;
  }

}