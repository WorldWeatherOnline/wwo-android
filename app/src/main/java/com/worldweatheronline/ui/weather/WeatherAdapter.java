package com.worldweatheronline.ui.weather;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.worldweatheronline.R;
import com.worldweatheronline.domain.entity.weather.Astronomy;
import com.worldweatheronline.domain.entity.weather.Weather;
import java.util.List;

/**
 * @user Kailash Dabhi (kailash09dabhi@gmail.com)
 * @date 23 Sep,2017 18:16
 */

public final class WeatherAdapter extends ArrayAdapter<Weather> {

  public WeatherAdapter(@NonNull Context context,
      @NonNull List<Weather> objects) {
    super(context, 0, objects);
  }

  @NonNull @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    ViewHolder holder;
    if (convertView == null) {
      convertView = LayoutInflater.from(parent.getContext())
          .inflate(R.layout.item_weather, null, false);
      holder = new ViewHolder(convertView);
      convertView.setTag(holder);

    } else {
      holder = (ViewHolder) convertView.getTag();
    }
    Weather weather = getItem(position);
    holder.tempView.setText(
        String.format("Temprature : %s - %s C (%s - %s F)",
            weather.mintempC,
            weather.maxtempC,
            weather.mintempF,
            weather.maxtempF)
    );
    holder.dateView.setText(weather.date);
    Astronomy astronomy = weather.astronomy.get(0);
    if (!weather.astronomy.isEmpty()) {
      holder.sunView.setText(
          String.format("Sunrise at %s & Sunset at %s",
              astronomy.sunrise,
              astronomy.sunset)
      );
      holder.moonView.setText(
          String.format("Moonrise at %s & Moonset at %s",
              astronomy.sunrise,
              astronomy.sunset)
      );

    }
    holder.sunHourView.setText("Sun hour: " + weather.sunHour);
    holder.uvIndexView.setText("Uv index: " + weather.uvIndex);
    return convertView;
  }

  class ViewHolder {

    @BindView(R.id.dateView) TextView dateView;
    @BindView(R.id.tempView) TextView tempView;
    @BindView(R.id.uvIndexView) TextView uvIndexView;
    @BindView(R.id.sunHourView) TextView sunHourView;
    @BindView(R.id.sunView) TextView sunView;
    @BindView(R.id.moonView) TextView moonView;

    ViewHolder(View view) {
      ButterKnife.bind(this, view);
    }
  }
}
