        public void addWeatherData(WeatherData weatherData) {
            for (WeatherData data : weatherDatas) {
                if (data.city.equals(weatherData.city)) {
                    return;
                }
            }
            weatherDatas.add(weatherData);
            notifyItemInserted(weatherDatas.size());
        }

