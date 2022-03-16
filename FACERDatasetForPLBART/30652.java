    public void setCityWeatherAsFavorite(CityWeather cityWeather) {

        int index = cityWeatherList.indexOf(cityWeather);

        if (index != -1) {

            CityWeather cw = cityWeatherList.get(index);
            cw.setFavorite(cityWeather.isFavorite());
            // TODO: lookup the exact position to use the notifyItemChanged(index) method instead
            notifyDataSetChanged();
        }
    }

