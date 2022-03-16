        @Override
        public void onBindViewHolder(ThreeHourlyForecastViewHolder holder, int position) {
            String jsonString = threeHourlyForecastJsonStrings.get(position);
            Gson gson = new Gson();
            CityThreeHourlyWeatherForecast forecast = gson.fromJson(jsonString,
                    CityThreeHourlyWeatherForecast.class);

            displayForecastTime(holder, forecast);
            weatherInformationDisplayer.displayConditions(forecast, holder.conditionsTextView,
                    holder.conditionsImageView);
            weatherInformationDisplayer.displayWeatherNumericParametersText(forecast,
                    holder.temperatureTextView, holder.pressureTextView, holder.humidityTextView);
            weatherInformationDisplayer.displayWindInfo(forecast, holder.windTextView);
        }

