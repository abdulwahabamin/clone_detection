    /**
     * If the three-hourly forecast should be displayed as a set of daily forecast lists,
     * the toolbar is updated with the queried city name.
     *
     * @param toolbar      toolbar for this activity
     * @param defaultTitle regular title without the city name
     */
    private void updateTitleWithCityNameIfNecessary(final Toolbar toolbar,
                                                    final String defaultTitle) {
        final Context context = this;
        if (SharedPrefsHelper.getForecastDisplayMode(context) ==
                ThreeHourlyForecastDisplayMode.LIST) {
            new Thread(new Runnable() {

                @Override
                public void run() {

                    int lastQueriedCityId = SharedPrefsHelper.getCityIdFromSharedPrefs(context);
                    if (lastQueriedCityId != CityTable.CITY_ID_DOES_NOT_EXIST) {
                        String queriedCityName = new SqlOperation(context)
                                .findCityName(lastQueriedCityId);
                        String updatedTitle = defaultTitle + TOOLBAR_TITLE_AND_CITY_NAME_SEPARATOR +
                                queriedCityName;
                        toolbar.setTitle(updatedTitle);
                    }

                }
            }).start();
        }
    }

