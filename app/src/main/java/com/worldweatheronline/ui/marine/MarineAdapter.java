package com.worldweatheronline.ui.marine;

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

public final class MarineAdapter extends ArrayAdapter<com.worldweatheronline.domain.entity.marine.Weather> {

  public MarineAdapter(@NonNull Context context,
      @NonNull List<com.worldweatheronline.domain.entity.marine.Weather> objects) {
    super(context, 0, objects);
  }

  @NonNull @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    ViewHolder holder;
    if (convertView == null) {
      convertView = LayoutInflater.from(parent.getContext())
          .inflate(R.layout.item_weather, null, false);
      holder = new ViewHolder(convertView);
      ((View)holder.uvIndexView.getParent()).setVisibility(View.GONE);
      convertView.setTag(holder);
    } else {
      holder = (ViewHolder) convertView.getTag();
    }
    com.worldweatheronline.domain.entity.marine.Weather weather = getItem(position);
    holder.tempView.setText(String
        .format("Min Temp: %s - %s C", weather.mintempC, weather.maxtempC));
    holder.dateView.setText(weather.date);
    com.worldweatheronline.domain.entity.marine.Astronomy astronomy = weather.astronomy.get(0);
    if (!weather.astronomy.isEmpty()) {
      holder.sunView
          .setText(String.format("Sunrise at %s & Sunset at %s", astronomy.sunrise,
              astronomy.sunset));
    }
    return convertView;
  }

  class ViewHolder {

    @BindView(R.id.tempView) TextView tempView;
    @BindView(R.id.dateView) TextView dateView;
    @BindView(R.id.sunView) TextView sunView;
    @BindView(R.id.uvIndexView) TextView uvIndexView;
    @BindView(R.id.sunHourView) TextView sunHourView;

    ViewHolder(View view) {
      ButterKnife.bind(this, view);
    }
  }
}
