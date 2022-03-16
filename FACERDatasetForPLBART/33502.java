    /**
     * Creates a new dialog asking for the city deletion confirmation.
     *
     * @param cityId   OpenWeatherMap ID for the city to be deleted
     * @param cityName city name in the database
     * @return a new dialog fragment with the specified arguments
     */
    public static DeleteCityDialog newInstance(int cityId, String cityName) {
        DeleteCityDialog dialogFragment = new DeleteCityDialog();
        Bundle b = new Bundle();
        b.putInt(CityManagementActivity.CITY_ID, cityId);
        b.putString(CITY_NAME, cityName);
        dialogFragment.setArguments(b);
        return dialogFragment;
    }

