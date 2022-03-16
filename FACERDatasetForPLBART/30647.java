    @Override
    public void onBindViewHolder(CityWeatherViewHolder holder, int position) {

        CityWeather cityWeather = cityWeatherList.get(position);

        holder.cityNameTextView.setText(cityWeather.getName());

        String weatherInCelsius = " - ";

        if (cityWeather.getMain() != null) {

            weatherInCelsius = WeatherUtils.getDegreesRepresentation(context,
                    WeatherUtils.convertToCelsius(cityWeather.getMain().getTemp()));
        }

        holder.cityWeatherDegreesTextView.setText(weatherInCelsius);
        holder.cityWeatherDescriptionTextView.setText(cityWeather.getWeather().get(0).getMain());
        holder.cityWeatherIconImageView.setImageResource(WeatherUtils
                .getArtResourceForWeatherCondition(cityWeather.getWeather().get(0).getId()));

        if (cityWeather.isFavorite()) {

            holder.cityWeatherFavoriteImageView.setImageResource(R.drawable.ic_favorite_white_36dp);
        } else {
            holder.cityWeatherFavoriteImageView.setImageResource(R.drawable.ic_favorite_border_white_36dp);
        }
    }

