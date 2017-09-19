package com.worldweatheronline;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.worldweatheronline.domain.entity.timezone.Api;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @user Kailash Dabhi (kailash09dabhi@gmail.com)
 * @date 19 Sep, 2017 13:05
 */

public final class TimezoneApiActivity extends AppCompatActivity {

  @BindView(R.id.timezoneView) TextView timezoneView;
  @BindView(R.id.nearestAreaView) TextView nearestAreaView;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_timezone);
    ButterKnife.bind(this);
//    fetchTimezone("Paris");
  }

  private void fetchTimezone(String location) {
    App.instance().apiService().timezone(location).enqueue(new Callback<Api>() {
      @Override public void onResponse(Call<Api> call, Response<Api> response) {
        Api timezone = response.body();
        if (timezone != null) {
          timezoneView.setText(timezone.toString());
        }
      }

      @Override public void onFailure(Call<Api> call, Throwable t) {

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