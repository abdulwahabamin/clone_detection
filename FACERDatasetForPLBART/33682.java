        /**
         * Obtains and displays the forecast start and end times.
         *
         * @param holder   helper class, holding various views
         * @param forecast weather forecast for one three hour period
         */
        private void displayForecastTime(ThreeHourlyForecastViewHolder holder,
                                         CityThreeHourlyWeatherForecast forecast) {
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            simpleDateFormat.applyLocalizedPattern(TIME_TEMPLATE);

            long startTime = forecast.getDate() * 1000;
            Date date = new Date(startTime);
            holder.forecastStartHourTextView.setText(simpleDateFormat.format(date));
        }

