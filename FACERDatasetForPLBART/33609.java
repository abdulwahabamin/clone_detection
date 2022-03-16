    @Override
    protected void displayExtraInfo(WeatherInformation weatherInformation) {
        CityCurrentWeather cityCurrentWeather = (CityCurrentWeather) weatherInformation;
        String extraInfo = cityCurrentWeather.getCityName();

        Context context = getContext();
        Resources res = getResources();
        SystemParameters systemParameters = cityCurrentWeather.getSystemParameters();
        long sunriseTime = systemParameters.getSunriseTime() * 1000;
        if (sunriseTime != 0) {
            extraInfo += "\n" + res.getString(R.string.sunrise_time) +
                    getTimeString(context, new Date(sunriseTime));
        }

        long sunsetTime = systemParameters.getSunsetTime() * 1000;
        if (sunsetTime != 0) {
            extraInfo += "\n" + res.getString(R.string.sunset_time) +
                    getTimeString(context, new Date(sunsetTime));
        }

        extraInfoTextView.setText(extraInfo);
    }

