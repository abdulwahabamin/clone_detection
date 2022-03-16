    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ForecastAdapter.ViewHolder holder, int position) {
        WeatherForecast weatherForecast = weatherForecasts.get(position);
        holder.weekTextView.setText(weatherForecast.getWeek());
        holder.dateTextView.setText(weatherForecast.getDate());
        holder.weatherIconImageView.setImageResource(R.mipmap.ic_launcher);
        holder.weatherTextView.setText(TextUtils.isEmpty(weatherForecast.getWeather()) ?
                (weatherForecast.getWeatherDay().equals(weatherForecast.getWeatherNight()) ?
                        weatherForecast.getWeatherDay() : weatherForecast.getWeatherDay() + "转" + weatherForecast.getWeatherNight())
                : weatherForecast.getWeather());
        holder.tempMaxTextView.setText(weatherForecast.getTempMax() + "°");
        holder.tempMinTextView.setText(weatherForecast.getTempMin() + "°");
    }

