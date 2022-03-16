    /**
     * Obtain the text and image views to be displayed in all types of weather information
     * fragments.
     *
     * @param view the root view for the fragment
     */
    protected void getCommonViews(View view) {
        extraInfoTextView = (TextView) view.findViewById(R.id.city_extra_info_text_view);
        conditionsTextView = (TextView) view.findViewById(R.id.weather_conditions_text_view);
        conditionsImageView = (ImageView) view.findViewById(R.id.weather_conditions_image_view);
        temperatureTextView = (TextView) view.findViewById(R.id.temperature_text_view);
        pressureTextView = (TextView) view.findViewById(R.id.atmospheric_pressure_text_view);
        humidityTextView = (TextView) view.findViewById(R.id.humidity_text_view);
        windTextView = (TextView) view.findViewById(R.id.wind_text_view);
    }

