    /**
     * Describes and illustrates the weather.
     *
     * @param weatherInformation various parameters describing weather
     */
    void displayConditions(WeatherInformation weatherInformation,
                           TextView conditionsTextView, ImageView conditionsImageView) {
        String weatherDescription = res.getString(WeatherConditionFinder.
                findWeatherConditionStringResourceId(weatherInformation.getWeatherConditionsId()));
        String capitalizedWeatherDescription = weatherDescription.substring(0, 1).toUpperCase() +
                weatherDescription.substring(1);
        conditionsTextView.setText(capitalizedWeatherDescription);

        String iconName = weatherInformation.getIconName();
        Bitmap bitmap = getIconFromMemoryCache(iconName);
        if (bitmap != null) {
            conditionsImageView.setImageBitmap(bitmap);
        } else {
            new SetIconDrawableTask(conditionsImageView).execute(iconName);
        }
    }

