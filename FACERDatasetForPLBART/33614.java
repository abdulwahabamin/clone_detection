    /**
     * Obtains a text to be displayed in the extraInfoTextView.
     *
     * @param cityDailyWeatherForecast Java object, corresponding to the Open Weather Map JSON
     *                                 weather forecast data for one day
     * @return a weather forecast date, time, and location
     */
    private String getExtraInfoText(CityDailyWeatherForecast cityDailyWeatherForecast) {
        Context context = getActivity();
        Date date = new Date(cityDailyWeatherForecast.getDate() * 1000);

        String weekdayName = MiscMethods.getAbbreviatedWeekdayName(date);
        String dateString = getDateString(context, date);
        String timeString = getTimeString(context, date);

        return weekdayName + ", " + dateString + "\n" + timeString + "\n" +
                getArguments().getString(CITY_NAME);
    }

