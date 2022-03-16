        @OnClick(R.id.city_weather_favorite_imageview)
        public void onCityWeatherFavoriteSelected() {

            CityWeather cityWeather = cityWeatherList.get(getAdapterPosition());

            if (favoriteListener != null && cityWeatherList.size() > getAdapterPosition()) {

                favoriteListener.onCityWeatherFavoriteSelected(cityWeather);
            }
        }

