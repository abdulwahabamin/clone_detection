    @MediumTest
    public void testCityList() {
        mainActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                instrumentation.callActivityOnStart(mainActivity);
            }

        });

        final ListView cityListView = (ListView) mainActivity
                .findViewById(android.R.id.list);
        assertNotNull("City list view not found", cityListView);

        // List items are loaded asynchronously, so we need to wait a little bit
        // to test them
        Runnable testListViewItemButtonClicksRunnable = testCityListRowButtonsRunnable(cityListView);
        new Handler().postDelayed(testListViewItemButtonClicksRunnable,
                LIST_VIEW_INITIALIZATION_DELAY);
    }

