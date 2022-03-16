    /**
     * Obtains the hour of the very first three-hourly forecast provided by OWM.
     *
     * @return the hour in range [0..23]
     */
    private int getFirstThreeHourlyForecastHour() {
        long firstForecastTime = 1000 * new Gson().fromJson(jsonStringsForChildFragments.get(0),
                CityThreeHourlyWeatherForecast.class).getDate();
        Date date = new Date(firstForecastTime);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        return calendar.get(Calendar.HOUR_OF_DAY);
    }

