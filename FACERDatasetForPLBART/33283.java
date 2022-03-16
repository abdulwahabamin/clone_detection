    private Runnable testCityListRowButtonsRunnable(final ListView cityListView) {
        return new Runnable() {

            private boolean isDualPane = (FrameLayout) mainActivity
                    .findViewById(R.id.weather_info_container) != null;

            @Override
            public void run() {
                int cityListViewItemCount = cityListView.getChildCount();
                if (cityListViewItemCount > 0) {
                    View listRowView = cityListView.getChildAt(cityListView
                            .getFirstVisiblePosition());
                    ArrayList<View> weatherButtons = listRowView
                            .getFocusables(View.FOCUS_FORWARD);
                    assertEquals(
                            "City list row should contain three views (weather buttons)",
                            3, weatherButtons.size());

                    testWeatherButtons(weatherButtons);
                }
            }

            private void testWeatherButtons(ArrayList<View> weatherButtons) {
                final View decorView = mainActivity.getWindow().getDecorView();

                Button currentWeatherButton = (Button) weatherButtons.get(0);
                assertNotNull("Weather button is null", currentWeatherButton);
                ViewAsserts.assertOnScreen(decorView, currentWeatherButton);
                testCurrentWeatherButtonClick(currentWeatherButton);

                Button dailyForecastButton = (Button) weatherButtons.get(1);
                assertNotNull("Daily forecast button is null",
                        dailyForecastButton);
                ViewAsserts.assertOnScreen(decorView, currentWeatherButton);
                testDailyWeatherForecastButtonClick(dailyForecastButton);

                Button threeHourlyForecastButton = (Button) weatherButtons
                        .get(2);
                assertNotNull("Three hourly forecast button is null",
                        threeHourlyForecastButton);
                ViewAsserts.assertOnScreen(decorView, currentWeatherButton);
                testThreeHourlyWeatherForecastButtonClick(threeHourlyForecastButton);
            }

            private void testCurrentWeatherButtonClick(
                    Button currentWeatherButton) {
                currentWeatherButton.performClick();
                if (isDualPane) {
                    testCurrentWeatherInfoFragment();
                } else {
                    testStartActivity_WeatherInfoActivity();
                }
            }

            private void testCurrentWeatherInfoFragment() {
                FragmentManager fragmentManager = mainActivity
                        .getSupportFragmentManager();
                fragmentManager.executePendingTransactions();

                WeatherCurrentInfoFragment weatherCurrentInfoFragment = (WeatherCurrentInfoFragment) fragmentManager
                        .findFragmentById(R.id.weather_info_container);
                assertNotNull(
                        "Weather current  info fragment not found in the layout [weather_info_container]",
                        weatherCurrentInfoFragment);
                assertTrue("Weather current  info fragment not added",
                        weatherCurrentInfoFragment.isAdded());
            }

            private void testStartActivity_WeatherInfoActivity() {
                ActivityMonitor activityMonitor = instrumentation.addMonitor(
                        WeatherInfoActivity.class.getName(), null, false);
                WeatherInfoActivity weatherInfoActivity = (WeatherInfoActivity) instrumentation
                        .waitForMonitorWithTimeout(activityMonitor,
                                ACTIVITY_MONITOR_TIMEOUT);

                assertTrue(
                        "Monitor for WeatherInfoActivity has not been called",
                        instrumentation.checkMonitorHit(activityMonitor, 1));

                instrumentation.removeMonitor(activityMonitor);
                weatherInfoActivity.finish();
            }

            private void testDailyWeatherForecastButtonClick(
                    Button dailyForecastButton) {
                dailyForecastButton.performClick();
                if (isDualPane) {
                    testWeatherForecastParentFragment();
                } else {
                    testStartActivity_WeatherInfoActivity();
                }
            }

            private void testWeatherForecastParentFragment() {
                FragmentManager fragmentManager = mainActivity
                        .getSupportFragmentManager();
                fragmentManager.executePendingTransactions();

                WeatherForecastParentFragment forecastParentFragment = (WeatherForecastParentFragment) fragmentManager
                        .findFragmentById(R.id.weather_info_container);
                assertNotNull(
                        "Weather forecast parent fragment not found in the layout [weather_info_container]",
                        forecastParentFragment);
                assertTrue("Weather forecast parent fragment not added",
                        forecastParentFragment.isAdded());
            }

            private void testThreeHourlyWeatherForecastButtonClick(
                    Button threeHourlyForecastButton) {
                threeHourlyForecastButton.performClick();
                if (isDualPane) {
                    testWeatherForecastParentFragment();
                } else {
                    testStartActivity_WeatherInfoActivity();
                }
            }

        };
    }

