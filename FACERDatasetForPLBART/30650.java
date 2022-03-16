    public void addCityWeather(CityWeather cityWeather) {

        int index = cityWeatherList.indexOf(cityWeather);

        // Skip when not found and for the first index
        if (index != -1 && index != 0) {

            CityWeather removed = cityWeatherList.remove(index);
            notifyItemRemoved(index);
            cityWeatherList.add(0, removed);
            notifyItemInserted(0);
        } else if (index == -1) {

            // prepend new cityweather
            cityWeatherList.add(0, cityWeather);
            notifyItemInserted(0);
        }
    }

