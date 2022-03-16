    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void displayExtraInfo(WeatherInformation weatherInformation) {
        CityThreeHourlyWeatherForecast threeHourlyWeatherForecast =
                (CityThreeHourlyWeatherForecast) weatherInformation;
        Context context = getActivity();
        Date date = new Date(threeHourlyWeatherForecast.getDate() * 1000);

        String weekdayName = MiscMethods.getAbbreviatedWeekdayName(date);
        String dateString = getDateString(context, date);
        String timeString = getTimeString(context, date);

        extraInfoTextView.setText(weekdayName + ", " + dateString + "\n" + timeString + "\n"
                + getArguments().getString(CITY_NAME));
    }

