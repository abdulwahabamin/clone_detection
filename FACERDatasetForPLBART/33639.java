    /**
     * Creates and adds the correct type of fragment to the activity.
     *
     * @param weatherInfoType a kind of weather information to be displayed on the screen
     * @param jsonString      a string representing the JSON weather data
     */
    private void addRequiredFragment(WeatherInfoType weatherInfoType, String jsonString) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment fragment = weatherInfoType == WeatherInfoType.CURRENT_WEATHER ?
                WeatherInfoFragment.newInstance(weatherInfoType, null, jsonString)
                : WeatherForecastParentFragment.newInstance(weatherInfoType, jsonString);
        fragmentTransaction.replace(R.id.weather_info_container, fragment);

        workerFragment = (WorkerFragmentToRetrieveJsonString) fragmentManager
                .findFragmentByTag(MainActivity.WORKER_FRAGMENT_TAG);
        if (workerFragment == null) {
            workerFragment = new WorkerFragmentToRetrieveJsonString();
            fragmentTransaction.add(workerFragment, MainActivity.WORKER_FRAGMENT_TAG);
        }

        fragmentTransaction.commit();
    }

