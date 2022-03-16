    /**
     * Creates and sets {@link WeatherThreeHourlyForecastChildListFragment}.
     *
     * @param threeHourlyForecastJsonStrings JSON strings obtained from the OWM, containing weather
     *                                       information
     * @return fragment, which should display the three-hourly forecasts for one day
     */
    public static WeatherThreeHourlyForecastChildListFragment newInstance(
            ArrayList<String> threeHourlyForecastJsonStrings) {
        WeatherThreeHourlyForecastChildListFragment fragment =
                new WeatherThreeHourlyForecastChildListFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(JSON_STRING_LIST, threeHourlyForecastJsonStrings);
        fragment.setArguments(args);
        return fragment;
    }

