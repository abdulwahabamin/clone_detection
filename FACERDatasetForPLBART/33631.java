        @Override
        public CharSequence getPageTitle(int position) {
            if (weatherInfoType == WeatherInfoType.DAILY_WEATHER_FORECAST) {
                return getPageTitleForDailyWeatherForecast(position);
            } else if (weatherInfoType == WeatherInfoType.THREE_HOURLY_WEATHER_FORECAST) {
                return getPageTitleForThreeHourlyWeatherForecast(position);
            } else {
                throw new WeatherInfoType.IllegalWeatherInfoTypeArgumentException(weatherInfoType);
            }
        }

