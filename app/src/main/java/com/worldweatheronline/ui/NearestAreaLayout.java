package com.worldweatheronline.ui;

import android.content.Context;
import android.os.Build.VERSION_CODES;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.worldweatheronline.R;
import com.worldweatheronline.domain.entity.timezone.AreaName;
import com.worldweatheronline.domain.entity.timezone.Country;
import com.worldweatheronline.domain.entity.timezone.NearestArea;
import com.worldweatheronline.domain.entity.timezone.Region;
import com.worldweatheronline.domain.entity.timezone.WeatherUrl;
import java.util.List;

/**
 * @user Kailash Dabhi (kailash09dabhi@gmail.com)
 * @date 23 Sep, 2017 12:35
 */

public final class NearestAreaLayout extends LinearLayout {

  @BindView(R.id.areaNameView) TextView areaNameView;
  @BindView(R.id.countryView) TextView countryView;
  @BindView(R.id.latitudeLongitudeView) TextView latitudeLongitudeView;
  @BindView(R.id.populationView) TextView populationView;
  @BindView(R.id.regionView) TextView regionView;

  public NearestAreaLayout(Context context) {
    super(context);
    init();
  }

  public NearestAreaLayout(Context context,
      @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public NearestAreaLayout(Context context,
      @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  @RequiresApi(api = VERSION_CODES.LOLLIPOP)
  public NearestAreaLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init();
  }

  private void init() {
    inflate(getContext(), R.layout.nearest_area, this);
  }

  private NearestArea nearestArea;

  public void bind(NearestArea nearestArea) {
    this.nearestArea = nearestArea;
    List<Region> regions = nearestArea.region;
    String region = "", areaName = "", country = "";
    if (!regions.isEmpty()) {
      regionView.setText("Region: " + regions.get(0).value);
      region = regions.get(0).value;
    }
    List<AreaName> areaNames = nearestArea.areaName;
    if (!regions.isEmpty()) {
      areaNameView.setText("Area name: " + areaNames.get(0).value);
      areaName = areaNames.get(0).value;
    }
    List<Country> countries = nearestArea.country;
    if (!countries.isEmpty()) {
      countryView.setText("Country: " + countries.get(0).value);
      country = countries.get(0).value;
    }
    populationView.setText(String.format(
        "%s(%s) is located at a latitude of %s & at longitude of %s.\n\n %s has population of around %s "
        , areaName, region, nearestArea.latitude, nearestArea.longitude, country,
        nearestArea.population));
    latitudeLongitudeView.setText(String.format("Latitude: %s, Longitude: %s ", nearestArea.latitude, nearestArea.longitude));
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
}
