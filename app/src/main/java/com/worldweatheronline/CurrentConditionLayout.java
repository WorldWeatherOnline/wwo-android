package com.worldweatheronline;

import android.content.Context;
import android.media.Image;
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
import com.worldweatheronline.domain.entity.timezone.AreaName;
import com.worldweatheronline.domain.entity.timezone.Country;
import com.worldweatheronline.domain.entity.timezone.Region;
import com.worldweatheronline.domain.entity.weather.CurrentCondition;
import com.worldweatheronline.domain.entity.weather.WeatherDesc;
import com.worldweatheronline.domain.entity.weather.WeatherIconUrl;
import java.util.List;

/**
 * @user Kailash Dabhi (kailash09dabhi@gmail.com)
 * @date 23 Sep, 2017 12:35
 */

public final class CurrentConditionLayout extends LinearLayout {

  @BindView(R.id.observationView) TextView observationView;
  @BindView(R.id.temperatureView) TextView temperatureView;
  @BindView(R.id.weatherDescView) TextView weatherDescView;
  @BindView(R.id.windView) TextView windView;
  @BindView(R.id.humidityView) TextView humidityView;
  @BindView(R.id.pressureView) TextView pressureView;
  @BindView(R.id.cloudCoverView) TextView cloudCoverView;
  @BindView(R.id.visibilityView) TextView visibilityView;
  @BindView(R.id.preciptMView) TextView preciptMView;
  @BindView(R.id.imageView) ImageView imageView;

  public CurrentConditionLayout(Context context) {
    super(context);
    init();
  }

  public CurrentConditionLayout(Context context,
      @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public CurrentConditionLayout(Context context,
      @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  @RequiresApi(api = VERSION_CODES.LOLLIPOP)
  public CurrentConditionLayout(Context context, AttributeSet attrs, int defStyleAttr,
      int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init();
  }

  private void init() {
    inflate(getContext(), R.layout.current_condition, this);
//    setOrientation(VERTICAL);
  }

  private CurrentCondition currentCondition;

  public void bind(CurrentCondition currentCondition) {
    this.currentCondition = currentCondition;
    observationView.setText("Observation Time: " + currentCondition.observationTime);
    temperatureView.setText("Temprature in Celicius: " + currentCondition.tempC + ", in Farenhit: "
        + currentCondition.tempF);
    List<WeatherDesc> weatherDescs = currentCondition.weatherDesc;
    if (!weatherDescs.isEmpty()) {
      weatherDescView.setText(weatherDescs.get(0).value);
    }
    windView.setText(String.format("Wind speed is %s Miles(%s kmph) at  %s degree (%s)",
        currentCondition.windspeedMiles, currentCondition.windspeedKmph,
        currentCondition.winddirDegree, currentCondition.winddir16Point));
    humidityView.setText("Humidity: " + currentCondition.humidity);
    pressureView.setText("Pressure: " + currentCondition.pressure);
    cloudCoverView.setText("Cloudcover: " + currentCondition.cloudcover);
    preciptMView.setText("PreciptM: " + currentCondition.precipMM);
    visibilityView.setText("PreciptM: " + currentCondition.visibility);
    List<WeatherIconUrl> weatherIcons = currentCondition.weatherIconUrl;
    if (!weatherDescs.isEmpty()) {
      Glide.with(imageView).load(weatherIcons.get(0).value).into(imageView);
    }
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
}
