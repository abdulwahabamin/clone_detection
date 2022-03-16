    @MediumTest
    public void testCityList() {
        cityManagementActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                instrumentation.callActivityOnStart(cityManagementActivity);
            }

        });

        final ListView cityListView = (ListView) cityManagementActivity
                .findViewById(android.R.id.list);
        assertNotNull("City list view not found", cityListView);

        // List items are loaded asynchronously, so we need to wait a little bit
        // to test them
        Runnable testListViewItemButtonClicksRunnable = testCityListRowUtilityButtonsRunnable(cityListView);
        new Handler().postDelayed(testListViewItemButtonClicksRunnable,
                LIST_VIEW_INITIALIZATION_DELAY);
    }

