        public void addWeatherDataWithPosition(WeatherData weatherData, int position) {
            //TODO 排�?
            if (weatherDatas.size() < position) {
                addWeatherData(weatherData);
            } else {

            }
            weatherDatas.add(position, weatherData);
            notifyItemInserted(position);
        }

