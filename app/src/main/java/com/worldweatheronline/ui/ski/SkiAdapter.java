package com.worldweatheronline.ui.ski;

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
import com.worldweatheronline.domain.entity.ski.Bottom;
import com.worldweatheronline.domain.entity.ski.Mid_;
import com.worldweatheronline.domain.entity.ski.Top_;
import java.util.List;

/**
 * @user Kailash Dabhi (kailash09dabhi@gmail.com)
 * @date 23 Sep,2017 18:16
 */

public final class SkiAdapter extends
    ArrayAdapter<com.worldweatheronline.domain.entity.ski.Weather> {

  public SkiAdapter(@NonNull Context context,
      @NonNull List<com.worldweatheronline.domain.entity.ski.Weather> objects) {
    super(context, 0, objects);
  }

  @NonNull @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    ViewHolder holder;
    if (convertView == null) {
      convertView = LayoutInflater.from(parent.getContext())
          .inflate(R.layout.item_ski, null, false);
      holder = new ViewHolder(convertView);
      convertView.setTag(holder);

    } else {
      holder = (ViewHolder) convertView.getTag();
    }
    com.worldweatheronline.domain.entity.ski.Weather weather = getItem(position);
    if (!weather.mid.isEmpty()) {
      Mid_ mid_ = weather.mid.get(0);
      holder.midTempView.setText(
          String.format("Mid:\n%s - %s C",
              mid_.mintempC,
              mid_.maxtempC)
      );
    }
    if (!weather.bottom.isEmpty()) {
      Bottom bottom = weather.bottom.get(0);
      holder.bottomTempView.setText(
          String.format("Bottom:\n%s - %s C",
              bottom.mintempC,
              bottom.maxtempC)
      );
    }
    if (!weather.top.isEmpty()) {
      Top_ top_ = weather.top.get(0);
      holder.topTempView.setText(
          String.format("Top:\n%s - %s C",
              top_.mintempC,
              top_.maxtempC)
      );
    }
    holder.dateView.setText(weather.date);
    com.worldweatheronline.domain.entity.ski.Astronomy astronomy = weather.astronomy.get(0);
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
    holder.totalSnowfallInCmView.setText("Total Snowfall in cm: " + weather.totalSnowfallCm);
    holder.chanceOfSnowView
        .setText(weather.chanceofsnow.equals("0") ? "There is no possiblity of snow."
            : "There is possiblity of snow."
        );
    return convertView;
  }

  class ViewHolder {

    @BindView(R.id.dateView) TextView dateView;
    @BindView(R.id.midTempView) TextView midTempView;
    @BindView(R.id.bottomTempView) TextView bottomTempView;
    @BindView(R.id.topTempView) TextView topTempView;
    @BindView(R.id.totalSnowfallInCmView) TextView totalSnowfallInCmView;
    @BindView(R.id.chanceOfSnowView) TextView chanceOfSnowView;
    @BindView(R.id.sunView) TextView sunView;
    @BindView(R.id.moonView) TextView moonView;

    ViewHolder(View view) {
      ButterKnife.bind(this, view);
    }
  }
}
