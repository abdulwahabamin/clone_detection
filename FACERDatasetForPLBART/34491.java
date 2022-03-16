        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            HeWeatherBuilder.HourlyForecast hourlyForecast = hourlyForecasts[position];
            holder.tmp.setText(hourlyForecast.tmp + WeatherConstant.CELSIUS_DEGRESS);
            holder.date.setText(hourlyForecast.date.split(" ")[1]);
            holder.pop.setText(hourlyForecast.pop + " %");
        }

